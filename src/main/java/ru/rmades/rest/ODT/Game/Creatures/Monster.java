package ru.rmades.rest.ODT.Game.Creatures;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Администратор on 14.08.2016.
 */
@Entity
@Table(name="Monsters")
public class Monster extends Creature{
    String name;
    String image;
    short minLevelForAttack;
    String description;

    public Monster(){}
    public Monster(String name, String image, short min, short level,short x, short y, short color){
        super(level,x,y,color);
        this.name = name;
        this.image = image;
        this.minLevelForAttack = min;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public short getMinLevelForAttack() {
        return minLevelForAttack;
    }

    public void setMinLevelForAttack(short minLevelForAttack) {
        this.minLevelForAttack = minLevelForAttack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
