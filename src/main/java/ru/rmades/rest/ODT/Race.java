package ru.rmades.rest.ODT;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Race extends Baff{
    String name;
    public Race(short atack,short health,short steps, String text,String name){
        super(atack, health, steps,text);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

