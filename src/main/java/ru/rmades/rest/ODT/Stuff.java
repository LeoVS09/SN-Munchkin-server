package ru.rmades.rest.ODT;

import java.awt.*;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Stuff extends Baff{
    private Image image;
    public Stuff(short atack,short health,short steps, String text, Image image){
        super(atack, health, steps, text);
        this.image = image;
    }
    public Image getImage(){
        return image;
    }
}
