package ru.rmades.rest.ODT;

import java.util.ArrayList;

/**
 * Created by Администратор on 14.08.2016.
 */
abstract class Creature {
    private Color           color;
    private short           level;
    private short           x;
    private short           y;
    private ArrayList<Baff> baffs;

    Creature(short level,short x, short y, Color color, ArrayList<Baff>  baffs){
        this.level = level;
        this.x = x;
        this.y = y;
        this.color = color;
        this.baffs = baffs;
    }

    public short getLevel() {
        return level;
    }

    public short getX() {
        return x;
    }

    public short getY() {
        return y;
    }

    public ArrayList<Baff> getBaffs() {
        return baffs;
    }

    public Color getColor() {
        return color;
    }

    public static enum Color{
        Blue, Red, Green
    }
}
