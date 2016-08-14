package ru.rmades.rest.ODT.Game.Map;

import java.awt.image.BufferedImage;

/**
 * Created by Администратор on 15.08.2016.
 */
public class Map{
    private Room[][] rooms;
    private Wall[][] walls;

    public Map() {
    }
    public Room openRoom(int x, int y){
        //rooms[x][y] = new Room();
        return rooms[x][y];
    }
    public boolean isOpen(int x, int y){
        return true;
    }
    public Wall getWall(int x, int y){
        //walls[x][y] = new Wall();
        return walls[x][y];
    }
}
