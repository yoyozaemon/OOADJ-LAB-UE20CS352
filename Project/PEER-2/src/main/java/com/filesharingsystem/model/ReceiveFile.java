/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filesharingsystem.model;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class ReceiveFile {
    private static ReceiveFile robj = new ReceiveFile();
    private ReceiveFile()
    {

    }
    
    public static ReceiveFile getInstance()
    {
        return robj;
    }

    public byte[] decrypt(File file, Crypto c) throws IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException
    {
        return c.decrypt(file);   
    }

    public myFile receive(String IP, int port, Crypto c, String name, String type, String checksum) throws Exception{
        boolean serverOpen = false;
        System.out.println(type);
        while(!serverOpen)
        {
            try
            {
                //Initialize socket
                Socket socket = new Socket(InetAddress.getByName(IP), port);
                byte[] contents = new byte[10000];
                //Initialize the FileOutputStream to the output file's full path.
                String filepath = System.getProperty("java.io.tmpdir");
                
                FileOutputStream fos = new FileOutputStream(filepath + "/tmp1");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                InputStream is = socket.getInputStream();
                //No of bytes read in one read() call
                int bytesRead = 0;
                while((bytesRead=is.read(contents))!=-1)
                    bos.write(contents, 0, bytesRead);
                bos.flush();
                socket.close();

                File output = new File(filepath + "/tmp1");
                         
                byte[] decrypted = decrypt(output, c);

                OutputStream os = new FileOutputStream(filepath + "/res");
                os.write(decrypted);
                
                File file = new File(filepath + "/res");
                InputStream fl = new FileInputStream(file);
  
                byte[] arr = new byte[(int)file.length()];
                fl.read(arr);
                fl.close();
                
                String checkSumVer = c.calculateChecksum(arr);
                
                if(!checkSumVer.equals(checksum))
                {
                    System.out.println("C1:"+checksum);
                    System.out.println("C2:"+checkSumVer);
                    return null;
                }
                
                myFile mf = new myFile();
                mf.setFile(arr);
                mf.setFileType(type);
                mf.setFileSize(""+file.length());
                mf.setFilename(name);
                
                os.close();
                serverOpen = true;
//                output.delete();
//                file.delete();
                
                return mf;
            }
            catch (Exception e)
            {
                continue;
            }
        }
        return null;


    }
}