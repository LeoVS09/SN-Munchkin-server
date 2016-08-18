package ru.rmades.rest;

/**
 * Created by Администратор on 17.08.2016.
 */

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserDAO extends CrudRepository<UserForDB, Long>{

    public UserForDB findByLogin(String login);
}
