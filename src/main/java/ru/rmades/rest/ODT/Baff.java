package ru.rmades.rest.ODT;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Baff {
    short atack;
    short health;
    short steps;
    String text;

    public Baff(short atack,short health,short steps, String text) {
        this.atack = atack;
        this.health = health;
        this.steps = steps;
        this.text = text;
    }

    public short getAtack() {
        return atack;
    }

    public void setAtacks(short atack) {
        this.atack = atack;
    }

    public short getHealth() {
        return health;
    }

    public void setHealth(short health) {
        this.health = health;
    }

    public short getSteps() {
        return steps;
    }

    public void setSteps(short steps) {
        this.steps = steps;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
