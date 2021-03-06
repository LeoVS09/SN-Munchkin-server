package ru.rmades.rest.controller.mobile;

/**
 * Created by Администратор on 15.08.2016.
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rmades.rest.FirebaseWrapper;
import ru.rmades.rest.JSONWrapper;
import ru.rmades.rest.ODT.UserDAOWrapper;
import ru.rmades.rest.ODT.UserData;
import ru.rmades.rest.controller.mobile.model.UserForTransaction;

@RestController
@RequestMapping("/mobile/user")
public class MobileUserController {
    private static final Logger log = LoggerFactory.getLogger(MobileUserController.class);
    private static final JSONWrapper json = new JSONWrapper();
    private static final FirebaseWrapper firebase = new FirebaseWrapper();

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

        try {
            UserData userData = userDAO.getIfHave(user);
            if (userData != null){
                response = firebase.getFirebaseToken(Long.toString(userData.getId()));
                userData.setToken(response);
                userDAO.save(userData);
                response = json.toString(response);
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
