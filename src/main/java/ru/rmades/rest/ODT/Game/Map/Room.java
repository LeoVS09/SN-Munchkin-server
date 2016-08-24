package ru.rmades.rest.ODT.Game.Map;

import ru.rmades.rest.ODT.Game.Creatures.Creature;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Администратор on 14.08.2016.
 */

@Entity
@Table(name="rooms")
public class Room extends Wall{

    @OneToMany
    @JoinTable(name="Room_Creatures",
            joinColumns = @JoinColumn(name="Room_id"),
            inverseJoinColumns = @JoinColumn(name="Creature_id"))
    private List<Creature> creatures;


    public Room(){super();}

    public Room(String image){super(image);}

}
