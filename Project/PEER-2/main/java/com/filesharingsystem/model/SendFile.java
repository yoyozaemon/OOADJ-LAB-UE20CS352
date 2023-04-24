/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filesharingsystem.model;
import com.filesharingsystem.model.Crypto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
/**
 *
 * @author sumukhbhat2701
 */
public class SendFile {
    private static SendFile sobj = new SendFile();
    private SendFile()
    {

    }
    
    public static SendFile getInstance()
    {
        return sobj;
    }

    public byte[] encrypt(File file, Crypto c) throws IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException
    {
        return c.encrypt(file);
    }

    public void send(File file, String IP, int port, Crypto c) throws Exception
    {
        //Initialize Sockets
        ServerSocket ssock = new ServerSocket(port);

        Socket socket = ssock.accept();
        //The InetAddress specification
        InetAddress IA = InetAddress.getByName(IP);
        

        // //Get socket's output stream
        OutputStream os = socket.getOutputStream();

        byte[] encrypted = encrypt(file, c);
        os.write(encrypted);
        os.flush();
        //File transfer done. Close the socket connection!
        socket.close();
        ssock.close();
    } 
}