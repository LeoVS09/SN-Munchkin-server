package ru.rmades.rest.controller.mobile.firebase.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rmades.rest.ODT.UserData;

/**
 * Created by Администратор on 26.08.2016.
 */
public class TalkTo extends TalkAll{
    private UserData user;
    private static final Logger log = LoggerFactory.getLogger(TalkTo.class);

    public TalkTo(UserData user, String data, String title){
        super(user.getGame(),data,title);
        this.user = user;
    }

    @Override
    public void run(){
        try{
            super.target = "\"to\" : \"" + user.getToken() + "\"";
            String notification = "\"notification\" : { \"title\" : \"" + title + "\", \"body\" : \"LOL\" }";
            sendPost("{ " + notification +", \"data\":{ \"inf\" : " + data + "}, " + target + " }");
        }catch (Exception e){

            log.info("Error: " + e.toString());

        }
    }
}
