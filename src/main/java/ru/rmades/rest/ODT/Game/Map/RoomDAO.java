package ru.rmades.rest.ODT.Game.Map;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Администратор on 25.08.2016.
 */


@Transactional
public interface RoomDAO extends CrudRepository<Room,Long>{

}
