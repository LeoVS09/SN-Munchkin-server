package ru.rmades.rest.ODT.Game.Creatures;

import ru.rmades.rest.ODT.Game.Baffs.Baff;
import ru.rmades.rest.ODT.Game.Baffs.ClasS;
import ru.rmades.rest.ODT.Game.Baffs.Race;
import ru.rmades.rest.ODT.Game.Baffs.Stuff;
import ru.rmades.rest.ODT.User;

import java.util.ArrayList;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Hero extends Creature{
    private User user;
    private short steps;
    private short health;
    private ArrayList<Stuff> stuffs;
    private ArrayList<Stuff> inHand;
    private ArrayList<Race>  races;
    private ArrayList<ClasS> classes;

    public Hero( Color color, ArrayList<Baff>  baffs){
        super((short)1,(short)0,(short)0,color,baffs);
    }

    public void addStuff(Stuff stuff){stuffs.add(stuff);}

    public void addInHand(Stuff stuff){
        stuffs.remove(stuff);
        inHand.add(stuff);
    }

    public void addRace(Race race){races.add(race);}

    public void addClass(ClasS cl){classes.add(cl);}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public short getSteps() {
        return steps;
    }

    public void setSteps(short steps) {
        this.steps = steps;
    }

    public short getHealth() {
        return health;
    }

    public void setHealth(short health) {
        this.health = health;
    }
}
