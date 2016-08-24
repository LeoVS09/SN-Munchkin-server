package ru.rmades.rest.ODT.Game.Creatures;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Администратор on 24.08.2016.
 */


@Transactional
public interface HeroDAO extends CrudRepository<Hero, Long> {


}
