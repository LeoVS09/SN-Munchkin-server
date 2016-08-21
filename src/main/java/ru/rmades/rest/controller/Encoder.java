package ru.rmades.rest.controller;

/**
 * Created by Администратор on 21.08.2016.
 */



public class Encoder {
    private static final String key = "lololol";

    public Encoder(){}

    public String getTocken(Long id){
        String token = key + Long.toString(id);
        return token;
    }

    public long getUserId(String token){
        token = token.substring(6);
        return Long.parseLong(token,10);
    }
}
