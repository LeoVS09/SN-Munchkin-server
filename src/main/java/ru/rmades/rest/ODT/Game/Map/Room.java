package ru.rmades.rest.ODT.Game.Map;

import ru.rmades.rest.ODT.Game.Baffs.Baff;
import ru.rmades.rest.ODT.Game.Creatures.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Room extends Wall{
    ArrayList<Creature> creatures;

    public Room(Image image,ArrayList<Baff> baffs) {
        super(image,baffs);
    }
    public void addIn(Creature creature){
        creatures.add(creature);
    }
}
