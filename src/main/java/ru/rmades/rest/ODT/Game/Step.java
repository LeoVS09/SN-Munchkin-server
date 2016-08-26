package ru.rmades.rest.ODT.Game;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Step {
    short x;
    short y;
    public Step(short x, short y){
        this.x = x;
        this.y = y;
    }

    public short getX() {
        return x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return y;
    }

    public void setY(short y) {
        this.y = y;
    }
}
