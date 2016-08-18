package ru.rmades.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Администратор on 19.08.2016.
 */
public class JSONWrapper {
    private static final ObjectMapper json = new ObjectMapper();

    public JSONWrapper(){}

    public String toString(String text){
        String unerror = "Unknown error";
        try{
            unerror = json.writeValueAsString(unerror);
            text = json.writeValueAsString(text);
            return text;
        }catch (Exception e){
            return unerror;
        }
    }
}
