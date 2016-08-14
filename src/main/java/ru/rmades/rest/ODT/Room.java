package ru.rmades.rest.ODT;

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
