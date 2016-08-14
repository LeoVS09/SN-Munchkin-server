package ru.rmades.rest.ODT;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Baff {
    short bonus;
    String text;

    public Baff(short bonus, String text) {
        this.bonus = bonus;
        this.text = text;
    }

    public short getBonus() {
        return bonus;
    }

    public void setBonus(short bonus) {
        this.bonus = bonus;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
