package ru.rmades.rest.controller;

/**
 * Created by Администратор on 17.08.2016.
 */

import ru.rmades.rest.User;
import ru.rmades.rest.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(MobileUserController.class);

    @Autowired
    private UserDAO userDao;

    @RequestMapping("/create")
    public String create(){
        String text;
        User user = new User("Trol", "lol");
        try {
            userDao.save(user);
        }catch (Exception e){
            text = "Exception: " + e.toString();
            log.info(text);
            return text;
        }
        text = "Save user";
        log.info(text);
        return text;
    }

    @RequestMapping("/get-user/{userLogin}")
    public String getByLogin(@PathVariable String userLogin){
        User user;
        String text;
        try{
            user = userDao.findByLogin(userLogin);
        }catch (Exception e){
            text = "Exception: " + e.toString();
            log.info(text);
            return text;
        }
        text = "User: " + user.getLogin() + " --- " + user.getPassword();
        log.info(text);
        return text;
    }

}
