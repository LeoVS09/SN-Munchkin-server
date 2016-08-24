package ru.rmades.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Администратор on 19.08.2016.
 */
public class JSONWrapper {
    private static final ObjectMapper json = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(JSONWrapper.class);

    public JSONWrapper(){}

    public <T> String  toString(T object){

        String text = "\"Unknown error\"";
        try{
            text = json.writeValueAsString(object);
            return text;
        }catch (Exception e){
            log.info(e.toString());
            return text;
        }
    }
}
