package ru.rmades.rest.ODT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rmades.rest.controller.mobile.UserForTransaction;

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
        UserData userForSave = new UserData(user.getLogin(),user.getPassword());
        userDao.save(userForSave);
    }

    public void save(UserData user) throws Exception{
        userDao.save(user);
    }

    public boolean isHave(UserForTransaction user){
        try {
            if(user.isEmpty())throw new Exception("User login or password is empty");
            UserData userInBase = userDao.findByLogin(user.getLogin());
            return user.getPassword().equals(userInBase.getPassword());
        }catch (Exception e){
            return false;
        }
    }

    public long getIdisHave(UserForTransaction user){
        try {
            if(user.isEmpty())throw new Exception("User login or password is empty");
            UserData userInBase = userDao.findByLogin(user.getLogin());
            return user.getPassword().equals(userInBase.getPassword()) ? userInBase.getId() : 0;
        }catch (Exception e){
            return 0;
        }
    }

    public UserData findByLogin(String login) throws Exception{
        return userDao.findByLogin(login);
    }

    public UserData findById(long id) throws Exception{
        return userDao.findById(id);
    }
}
