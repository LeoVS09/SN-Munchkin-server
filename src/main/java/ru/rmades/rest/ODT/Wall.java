package ru.rmades.rest.ODT;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Wall {
    long id;
    Image image;
    ArrayList<Baff> baffs;
    public Wall(Image image,ArrayList<Baff> baffs){
        this.image = image;
        this.baffs = baffs;
    }
}
