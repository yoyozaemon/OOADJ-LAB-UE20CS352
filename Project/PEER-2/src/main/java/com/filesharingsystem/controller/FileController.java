package com.filesharingsystem.controller;
//package com.demo.fileUpload.controller;

import com.filesharingsystem.model.myFile;
import com.filesharingsystem.model.Client;
import com.filesharingsystem.model.Peer;
import com.filesharingsystem.model.UserFactory;
import com.filesharingsystem.model.Room;
import com.filesharingsystem.model.ReceiveFile;
import com.filesharingsystem.model.Crypto;
import com.filesharingsystem.model.SendFile;
import com.filesharingsystem.service.DBService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.filesharingsystem.model.CustomMultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

//@RestController
//@CrossOrigin("*")
@Controller


public class FileController {

    UserFactory f = new UserFactory();
    Room room;
    Client client;
    Peer peer;
    boolean isClient;
    // REST API ports(connection ports)
    String mainPort;
    String mainIP;
    // For data ports: client.getIP()/getPort()
    
    // For clients connection port/IP:
    String clink;
    Crypto c;
    @Autowired
    private DBService fileService;

    private String registerMyself(String myself, String link) throws IOException, InterruptedException
    {
        HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(link+"/register/"+myself))
                        .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return response.body();
        
    }
    
    private List<String> getAllPeers() throws IOException, InterruptedException
    {
        HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(clink+"/getAllPeersFromClient"))
                        .build();
                
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        
        String s = response.body().substring(1, response.body().length() - 1);
        String[] s2 = s.split(", ");
        List<String> strList = new ArrayList<String>(Arrays.asList(s2));
        return strList;
    }
    
    @GetMapping("/register/{peer}")
    @ResponseBody   // saying that return response body and not template/html
    public String register(@PathVariable String peer)
    {
        room.addPeers(peer);
        System.out.println(room.getPeers());
        return room.getKey();
    }
    
    @GetMapping("/getAllPeersFromClient")
    @ResponseBody   // saying that return response body and not template/html
    public String getAllPeersFromClientFunc()
    {
        return room.getPeers().toString();
    }
    
    
    
    @PostMapping("/send/{id}")
    public RedirectView sendFileFunc(@PathVariable String id) throws Exception
    {
        myFile file = fileService.getFile(id);
        SendFile s = SendFile.getInstance();
        List<String> peers = getAllPeers();
        String myself = mainIP+":"+mainPort;
        
        String srcDataIP, srcDataPort;
        if(isClient)
        {
            srcDataIP = client.getIP();
            srcDataPort = client.getPort();
        }
        else
        {
            srcDataIP = peer.getIP();
            srcDataPort = peer.getPort();
        }

        String filepath = System.getProperty("java.io.tmpdir")+"/tmp";
        File tmpFile = new File(filepath);
        OutputStream os = new FileOutputStream(tmpFile);
        os.write(file.getFile());
        os.close();
        
        FileInputStream fl = new FileInputStream(tmpFile);
        byte[] fileBuffer = new byte[(int)tmpFile.length()];
        fl.read(fileBuffer);
        fl.close();
        
        String checksum = c.calculateChecksum(fileBuffer);
        
        String params = "IP="+srcDataIP+"&port="+srcDataPort+"&name="+file.getFilename()+"&type="+file.getFileType()+"&checksum="+checksum;
                
        for(String peer_: peers)
        {
            if(!peer_.equals(myself))
            {
                
                HttpClient client_ = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://"+peer_+"/receiveFile?"+params))
                        .build();

                client_.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(response -> { System.out.println(response.statusCode());
                        return response; } )
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println);
              
            
                if(isClient)
                    s.send(tmpFile, client.getIP(), Integer.parseInt(client.getPort()), c);
                else
                    s.send(tmpFile, peer.getIP(), Integer.parseInt(peer.getPort()), c);
//                
//                try
//                {
//                    tmpFile.delete();
//                }
//                catch(Exception e)
//                {
//                    
//                }

            }
        }

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://"+mainIP+":"+mainPort+"/showAllFiles");
        redirectView.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        return redirectView;
    }
    
    @GetMapping("/receiveFile")
    public RedirectView receiveFileFunc(@RequestParam String IP, @RequestParam String port, @RequestParam String name, @RequestParam String type, @RequestParam String checksum) throws Exception
    {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://"+mainIP+":"+mainPort+"/showAllFiles");
        redirectView.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        
        ReceiveFile r = ReceiveFile.getInstance();
        if(r == null)
        {
            return redirectView;
        }
        myFile output = r.receive(IP, Integer.parseInt(port), c, name, type, checksum);
        CustomMultipartFile custom = new CustomMultipartFile(output.getFile(), output.getFilename(), output.getFileType(), (long)Integer.parseInt(output.getFileSize()));
        fileService.addFileCustom(custom);
        return redirectView;

    }
    
    @PostMapping("/createRoom")
    public String createRoomFunc(HttpServletRequest request, Model model, String nickname) throws JsonProcessingException, IOException, InterruptedException
    {
        fileService.deleteAll();
        isClient = true;
        clink = request.getRequestURL().toString().split("/")[0]+"//"+request.getRequestURL().toString().split("/")[2];
        client = (Client)f.getObject(2,nickname,clink);
        client = new Client(nickname, clink);
        room = client.getRoom();
        peer = null;
        mainIP = request.getLocalName();
        mainPort = ""+request.getLocalPort();
        c = new Crypto(room.getKey());
        room.addPeers(mainIP+":"+mainPort);
    
        return "upload";
    }
    
    @PostMapping("/joinRoom")
    public String joinRoomFunc(HttpServletRequest request, Model model, String nickname, String link) throws IOException, InterruptedException
    {
        fileService.deleteAll();
        clink = link;
        isClient = false;
        room = null;
        peer = (Peer)f.getObject(1, nickname,null);
        //peer = new (nickname);
        client = null;
        mainIP = request.getLocalName();
        mainPort = ""+request.getLocalPort();
        String key_ = registerMyself(mainIP+":"+mainPort,link);
        c = new Crypto(key_);
        
        return "upload";
    }
    

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file) throws IOException {
            String id = fileService.addFile(file);
            return "upload";
    }
    
    @GetMapping("/getFiles")
    public ResponseEntity<?> getFilesRoute() throws IOException
    {
        return new ResponseEntity<>(fileService.getFiles().toString(), HttpStatus.OK);
    }
    
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id) throws IOException {
        fileService.deleteFile(id);
        return "upload";
    }
    
    @GetMapping("/showAllFiles")
    public String showAllFiles()
    {
        return "upload";
    }
    
    @PostMapping("/showAllFiles")
    public String showAllFilesPost()
    {
        return "upload";
    }

    @PostMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
        myFile loadFile = fileService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(loadFile.getFileType() ))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + loadFile.getFilename() + "\"")
                .body(new ByteArrayResource(loadFile.getFile()));
    }

}