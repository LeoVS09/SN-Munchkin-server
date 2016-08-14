package ru.rmades.rest.ODT;

import java.util.ArrayList;

/**
 * Created by Администратор on 14.08.2016.
 */
public class Game {
    long id;
    private ArrayList<User>   users;
    private ArrayList<Hero>   heroes;
    private Map               map;
    private ArrayList<Card>   cards;
    private boolean   open;

    public Game(ArrayList<User>  users, boolean open) {
        this.users = users;
        this.open = open;

    }
    public void addHero(Hero hero){
        heroes.add(hero);
    }
    public Room openRoom(int x, int y){
        return map.openRoom(x,y);
    }
    public Wall getWall(int x, int y){
        return map.getWall(x,y);
    }
    public Card getCard(){
        Card card = new Card;
        cards.add(card);
        return card;
    }
    boolean isOpen(){
        return open;
    }

}
     class Map{
        Room [][] rooms;
        Wall [][] walls;

        public Map() {
        }
        public Room openRoom(int x, int y){
            return new Room();
        }
        public boolean isOpen(int x, int y){
            return true;
        }
        public Wall getWall(int x, int y{
            return new Wall();
        }
    }