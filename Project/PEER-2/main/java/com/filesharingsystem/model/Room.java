/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filesharingsystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sumukhbhat2701
 */
public class Room {
    String link;
    int numUsers;
    String creator;
    List<String> peers;
    Crypto cryp;
    
    public String getKey()
    {
        return cryp.key;
    }
    String getAlphaNumericString(int n)
    {
        // chose a Character random from this String
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                            .charAt(index));
        }
        return sb.toString();
    }

    public Room(String creator_, String link_)
    {
        numUsers = 0;
        creator = creator_;
        peers = new ArrayList<String>();
     
        link = link_;
        
        String key_ = getAlphaNumericString(16);
        cryp = new Crypto(key_);
    }

    public int getNumUsers()
    {
        return numUsers;
    }
    public List<String> getPeers()
    {
        return peers;   
    }

    public String getClient()
    {
        return creator;
    }

    public void addPeers(String peer)
    {
        peers.add(peer);
        numUsers++;
    }
}
