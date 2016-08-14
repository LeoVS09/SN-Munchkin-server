package ru.rmades.rest.ODT.Game;

import ru.rmades.rest.ODT.Game.Baffs.Card;
import ru.rmades.rest.ODT.Game.Creatures.Hero;
import ru.rmades.rest.ODT.User;
import ru.rmades.rest.ODT.Game.Map.*;

import java.awt.image.BufferedImage;
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
    public Card getCard(){;
        //cards.add(new Card());
        return cards.get(cards.size()-1);
    }
    boolean isOpen(){
        return open;
    }

}
