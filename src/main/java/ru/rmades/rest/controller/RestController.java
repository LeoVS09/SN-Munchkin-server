package ru.rmades.rest.controller;

/**
 * Created by Администратор on 15.08.2016.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/mobile")
public class RestController {
    private static final Logger log = LoggerFactory.getLogger(PostController.class);


    @RequestMapping(value="/user/registration", method = RequestMethod.POST)
    public ResponseEntity<Void> Registration(@RequestHeader HttpHeaders headers, @RequestBody User user){
        if(user.getLogin() == "Trol" && user.getPassword() == "lol") return new ResponseEntity<Void>(HttpStatus.OK);
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/user/login", method = RequestMethod.POST)
    public ResponseEntity<String> LoginIn(@RequestHeader HttpHeaders headers, @RequestBody User user){
        String token = "lololol";
        if(user.getLogin() == "Trol" && user.getPassword() == "lol") return new ResponseEntity<String>(token, HttpStatus.OK);
        return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/game/create", method = RequestMethod.POST)
    public ResponseEntity<String> gameCreate(@RequestHeader HttpHeaders headers, @RequestBody Game game){
        if(headers.get("Authorization").equals("lololol")) return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
        long id = 101;
        if(game.getName() == "Trol" && game.getPassword() == "lol") return new ResponseEntity<String>(Long.toString(id), HttpStatus.OK);
        return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
    }
}
