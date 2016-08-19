package ru.rmades.rest.controller;

/**
 * Created by Администратор on 15.08.2016.
 */



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rmades.rest.JSONWrapper;
import ru.rmades.rest.ODT.UserDAOWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/mobile/user")
public class MobileUserController {
    private static final Logger log = LoggerFactory.getLogger(MobileUserController.class);

    private static final JSONWrapper json = new JSONWrapper();

    @Autowired
    private UserDAOWrapper userDAO;
    private String response;

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public ResponseEntity<String> Registration(@RequestHeader HttpHeaders headers, @RequestBody UserForTransaction user){
        log.info("------->" + user.getLogin() + ": " + user.getPassword());
        String response = "Success";
        try {
            userDAO.save(user);
            log.info(response);
            response = json.toString(response);
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }catch (Exception e) {
            response = "Error: " + e.getMessage();
            log.info(response);
            response = json.toString(response);
            return new ResponseEntity<String>(response,HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<String> LoginIn(@RequestHeader HttpHeaders headers, @RequestBody UserForTransaction user){
        log.info("------->" + user.getLogin() + ": " + user.getPassword());
        String response = "lololol";
        response = json.toString(response);
        try {
            if (userDAO.isHave(user)){
                log.info("User in base");
                return new ResponseEntity<String>(response, HttpStatus.OK);
            }
            response = "Error: User not found";
        }catch (Exception e){
            response = "Error: " + e.getMessage();
        }
        log.info(response);
        response = json.toString(response);
        return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
    }

}
