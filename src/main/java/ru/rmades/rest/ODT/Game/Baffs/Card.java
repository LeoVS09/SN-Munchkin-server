package ru.rmades.rest.ODT.Game.Baffs;

import java.awt.*;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Card extends Stuff{
    private Image image;
    public Card(short atack,short health,short steps, String text,Image image){
        super(atack, health, steps, text, image);
    }
}
