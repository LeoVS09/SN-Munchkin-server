package ru.rmades.rest.controller.mobile.firebase.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.rmades.rest.ODT.Game.Game;
import ru.rmades.rest.ODT.UserData;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.net.URI;
import java.util.List;

/**
 * Created by Администратор on 24.08.2016.
 */

public class TalkAll implements Runnable{
    private Game game;
    private static final Logger log = LoggerFactory.getLogger(TalkAll.class);
    private HttpHeaders headers = new HttpHeaders();
    private JsonObjectBuilder message = Json.createObjectBuilder();
    private URI uri;
    public TalkAll(Game game,String data){
        this.game = game;
        message.add("data",data);
        headers.add("Content-Type","application/json");
        headers.add("Authorisation","key=" + "AIzaSyAWGFHIeb1vAAUXQzeKTFTDWFDh-8-yXmI");
        try {
            uri = new URI("https://fcm.googleapis.com/fcm/send");
        }catch (Exception e){
            log.info(e.toString());
        }
    }


    @Override
    public void run(){
        try {
            List<UserData> users = getUsers();
            JsonArrayBuilder tokens = Json.createArrayBuilder();

            for(UserData user: users){
                tokens.add(user.getToken());
            }

            if(users.size() == 1)
                message.add("to", users.get(0).getToken());
            else
                message.add("registration_ids",tokens);

            RequestEntity request = new RequestEntity(message.toString(), headers, HttpMethod.POST,uri);
            RestTemplate rest = new RestTemplate();
            ResponseEntity response = rest.exchange(request,String.class);

            log.info(response.toString());

        }catch (Exception e){

            log.info("Error: " + e.toString());

        }
    }

    private List<UserData> getUsers()throws Exception{
        List<UserData> users = game.getUsers();
        if(users == null || users.size() == 0) throw new Exception("Not found users in game");
        return users;
    }
}
