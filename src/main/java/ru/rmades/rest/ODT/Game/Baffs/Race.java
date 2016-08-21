package ru.rmades.rest.ODT.Game.Baffs;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Администратор on 14.08.2016.
 */
@Entity
@Table(name="Races")
public class Race extends Card{
    public Race(){}
    public Race(String name,String image, String description){
        super(name,image,description);
    }
}

