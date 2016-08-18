package ru.rmades.rest.controller;

/**
 * Created by Администратор on 17.08.2016.
 */


import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ru.rmades.rest.User;
import ru.rmades.rest.UserDAO;

@RestController
public class HomeController {

//    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

//    public String lol(){
//        return "lol";
//    }

    @Autowired
    private UserDAO userDao;

    @RequestMapping("/create")
    public String create(){
        String text;
        User user = new User("Troler", "loler");
        try {
            userDao.save(user);
        }catch (Exception e){
            text = "Exception: " + e.toString();
//            log.info(text);
            return text;
        }
        text = "Save user";
//        log.info(text);
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
//            log.info(text);
            return text;
        }
        text = "User: " + user.getLogin() + " --- " + user.getPassword();
//        log.info(text);
        return text;
    }

}
