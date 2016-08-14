package ru.rmades.rest.ODT;

import java.awt.*;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Stuff extends Baff{
    private Image image;
    public Stuff(short bonus, String text, Image image){
        super(bonus,text);
        this.image = image;
    }
    public Image getImage(){
        return image;
    }
}
