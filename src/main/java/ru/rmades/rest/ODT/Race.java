package ru.rmades.rest.ODT;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Race extends Baff{
    String name;
    public Race(short bonus, String text,String name){
        super(bonus,text);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

