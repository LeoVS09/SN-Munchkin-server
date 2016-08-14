package ru.rmades.rest.ODT;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Monstr extends Creature{
    long id;
    String name;
    Image image;
    short minAttack;

    public Monstr(String name, Image image, short min, short level,short x, short y, Color color, ArrayList<Baff> baffs){
        super(level,x,y,color,baffs);
        this.name = name;
        this.image = image;
        this.minAttack = min;
    }
}
