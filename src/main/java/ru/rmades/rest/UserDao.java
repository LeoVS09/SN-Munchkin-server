package ru.rmades.rest;

/**
 * Created by Администратор on 17.08.2016.
 */

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import ru.rmades.rest.controller.User;

@Transaction
public class UserDao implements IUserDao{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveUser(){
        User user = new User();
        user.setId(1);
        user.setLogin("Trol");
        user.setPassword("lol");
        hibernateTemplate.save(user);
    }
}
