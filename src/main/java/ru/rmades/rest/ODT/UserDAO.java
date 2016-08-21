package ru.rmades.rest.ODT;

/**
 * Created by Администратор on 17.08.2016.
 */

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserDAO extends CrudRepository<UserData, Long>{

    public UserData findByLogin(String login);

    public UserData findById(Long id);
}
