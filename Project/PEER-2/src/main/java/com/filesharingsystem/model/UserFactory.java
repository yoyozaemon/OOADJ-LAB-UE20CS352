package com.filesharingsystem.model;

public class UserFactory {
    public Object getObject(int x, String nickname, String clink){
        if(x==1){
            return new Peer(nickname);
        }
        else{
            return new Client(nickname,clink);
        }
    }
}