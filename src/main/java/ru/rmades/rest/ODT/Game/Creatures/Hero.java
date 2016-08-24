package ru.rmades.rest.ODT.Game.Creatures;

import ru.rmades.rest.ODT.Game.Baffs.ClasS;
import ru.rmades.rest.ODT.Game.Baffs.Race;
import ru.rmades.rest.ODT.Game.Baffs.Stuff;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Администратор on 14.08.2016.
 */

@Entity
@Table(name="Heroes")
public class Hero extends Creature{

    private short steps;
    private short health;

    @OneToMany
    @JoinTable(name="Heroes_Stuffs",
            joinColumns = @JoinColumn(name="Heroes_id"),
            inverseJoinColumns = @JoinColumn(name="Stuffs_id"))
    private List<Stuff> stuffs;
    @OneToMany
    @JoinTable(name="Heroes_inHand",
            joinColumns = @JoinColumn(name="Heroes_id"),
            inverseJoinColumns = @JoinColumn(name="inHand_id"))
    private List<Stuff> inHand;
    @OneToMany
    @JoinTable(name="Heroes_races",
            joinColumns = @JoinColumn(name="Heroes_id"),
            inverseJoinColumns = @JoinColumn(name="races_id"))
    private List<Race> races;
    @OneToMany
    @JoinTable(name="Heroes_Classes",
            joinColumns = @JoinColumn(name="Heroes_id"),
            inverseJoinColumns = @JoinColumn(name="Classes_id"))
    private List<ClasS> classes;

    public Hero(){}
    public Hero(short level,short x, short y, Short color){
        super(level,x,y,color);

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

    public List<Stuff> getStuffs() {
        return stuffs;
    }

    public void setStuffs(List<Stuff> stuffs) {
        this.stuffs = stuffs;
    }

    public List<Stuff> getInHand() {
        return inHand;
    }

    public void setInHand(List<Stuff> inHand) {
        this.inHand = inHand;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public List<ClasS> getClasses() {
        return classes;
    }

    public void setClasses(List<ClasS> classes) {
        this.classes = classes;
    }
}
