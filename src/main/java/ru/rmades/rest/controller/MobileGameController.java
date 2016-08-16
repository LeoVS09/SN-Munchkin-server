package ru.rmades.rest.controller;

/**
 * Created by Администратор on 16.08.2016.
 */

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/mobile/game")
public class MobileGameController {
    private static final Logger log = LoggerFactory.getLogger(MobileGameController.class);

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<String> gameCreate(@RequestHeader HttpHeaders headers, @RequestBody Game game)throws Exception{
        if(headers.get("Authorization").equals("lololol")) return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
        long id = 101;
        ObjectMapper mapper = new ObjectMapper();
        log.info("------->" + game.getName() + ": " + game.getPassword());
        if(game.getName().equals("Trol") && game.getPassword().equals("lol")) return new ResponseEntity<String>(mapper.writeValueAsString(Long.toString(id)), HttpStatus.OK);
        return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
    }

}
