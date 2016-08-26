package ru.rmades.rest.ODT.Game.Baffs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Администратор on 26.08.2016.
 */

@Transactional
public interface CardDAO extends CrudRepository<Card,Long> {
}
