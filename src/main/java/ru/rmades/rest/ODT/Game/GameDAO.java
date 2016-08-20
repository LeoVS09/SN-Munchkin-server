package ru.rmades.rest.ODT.Game;

/**
 * Created by Администратор on 20.08.2016.
 */

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;


@Transactional
public interface GameDAO extends CrudRepository<Game, Long>{

    public Game findByName(String name);
}
