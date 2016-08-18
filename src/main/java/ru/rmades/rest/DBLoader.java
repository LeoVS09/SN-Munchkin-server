package ru.rmades.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Администратор on 17.08.2016.
 */

@Service
public class DBLoader {
    private final UserDAO userDAO;

    @Autowired
    public DBLoader(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @PostConstruct
    private void initDatabase(){
        User user = new User("Trol","lol");
        try {
            userDAO.save(user);
        }catch(Exception e){
            System.out.println("Can't save user:"+ user.getLogin() +"\n" + e.getMessage());
        }

    }
}
