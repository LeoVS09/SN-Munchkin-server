package ru.rmades.rest.ODT.Game.Baffs;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Администратор on 14.08.2016.
 */

@Entity
@Table(name="classes")
public class ClasS extends Card {
    public ClasS(){};
    public ClasS(String name,String image,String description){
        super(name,image,description);
    }
}
