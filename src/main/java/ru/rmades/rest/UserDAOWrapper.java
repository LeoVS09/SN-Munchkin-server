package ru.rmades.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rmades.rest.controller.UserForTransaction;

/**
 * Created by Администратор on 18.08.2016.
 */

@Component
public class UserDAOWrapper {

    @Autowired
    private UserDAO userDao;

    public UserDAOWrapper(){}

    public void save(UserForTransaction user)throws Exception{
        if(user.isEmpty())throw new Exception("User login or password is empty");
        UserForDB userForSave = new UserForDB(user.getLogin(),user.getPassword());
        userDao.save(userForSave);
    }

    public boolean isHave(UserForTransaction user){
        try {
            if(user.isEmpty())throw new Exception("User login or password is empty");
            UserForDB userInBase = userDao.findByLogin(user.getLogin());
            return user.getPassword().equals(userInBase.getPassword());
        }catch (Exception e){
            return false;
        }
    }
}
