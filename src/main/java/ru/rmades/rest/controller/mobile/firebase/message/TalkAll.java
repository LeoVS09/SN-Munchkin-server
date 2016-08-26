package ru.rmades.rest.controller.mobile.firebase.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import ru.rmades.rest.ODT.Game.Game;
import ru.rmades.rest.ODT.UserData;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 24.08.2016.
 */

public class TalkAll implements Runnable{
    protected Game game;
    private static final Logger log = LoggerFactory.getLogger(TalkAll.class);
    protected HttpHeaders headers = new HttpHeaders();
    protected URI uri;
    protected String data;
    protected String target;
    protected String title;
    public TalkAll(Game game,String data,String title){
        this.game = game;
        this.data = data;
        this.title = title;
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization","key=AIzaSyAWGFHIeb1vAAUXQzeKTFTDWFDh-8-yXmI");
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
            ArrayList<String> tokens = new ArrayList<>();
            for(UserData user: users){
                log.info("-------------->" + user.getLogin() + ": " + user.getToken());
                if(!tokens.contains(user.getToken())) tokens.add(user.getToken());
            }
            if(tokens.size() == 1)
                target = "\"to\" : \"" + tokens.get(0) + "\"";
            else{
                target = "\"registration_ids\" : [ ";
                for(String token:tokens)
                    target += "\"" + token + "\",";
                target = target.substring(0,target.length()-1);
                target += " ]";
            }

            log.info("--------> Header: " + headers.toString());
            log.info("--------> Target: " + target);
            String notification = "\"notification\" : { \"title\" : \"" + title + "\", \"body\" : \"LOL\" }";
            sendPost("{ " + notification +", \"data\":{ \"inf\" : " + data + "}, " + target + " }");
//            RequestEntity<JsonObject> request = new RequestEntity(message.build(), headers, HttpMethod.POST,uri);
//            RequestEntity<JsonObject> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).header("Authorization","key=AIzaSyAWGFHIeb1vAAUXQzeKTFTDWFDh-8-yXmI").body(message.build());
//            log.info("--------> Entity: " + request.toString());
//            RestTemplate rest = new RestTemplate();
//            ResponseEntity response = rest.exchange(request,String.class);

//            log.info(response.toString());

        }catch (Exception e){

            log.info("Error: " + e.toString());

        }
    }

    private List<UserData> getUsers()throws Exception{
        List<UserData> users = game.getUsers();
        if(users == null || users.size() == 0) throw new Exception("Not found users in game");
        return users;
    }

    public void sendPost(String body)throws Exception{

        System.out.println("---------->Body: " + body);

        URL obj = new URL("https://fcm.googleapis.com/fcm/send");
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
//        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "key=AIzaSyAWGFHIeb1vAAUXQzeKTFTDWFDh-8-yXmI");


        // Send post request
        con.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(body);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        log.info("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        log.info(response.toString());
    }
}
