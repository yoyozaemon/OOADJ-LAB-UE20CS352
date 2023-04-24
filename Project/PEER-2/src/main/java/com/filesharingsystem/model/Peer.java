/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filesharingsystem.model;

/**
 *
 * @author sumukhbhat2701
 */
public class Peer extends Client {
    String id;
    public Peer(String id_)
    {
        super(null, null);
        id = id_;
        int min = 5000;
        int max = 8000;
        int port_ = (int)(Math.random()*(max-min+1)+min);
        port = Integer.toString(port_);
        IP = "127.0.0.1";
    }

    @Override
    public String getNickname()
    {
        return id;
    }
}
