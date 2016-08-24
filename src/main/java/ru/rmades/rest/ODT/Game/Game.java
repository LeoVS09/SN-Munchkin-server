package ru.rmades.rest.ODT.Game;

import ru.rmades.rest.ODT.Game.Baffs.Card;
import ru.rmades.rest.ODT.Game.Map.Map;
import ru.rmades.rest.ODT.UserData;
import ru.rmades.rest.controller.mobile.model.GameForTransaction;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Администратор on 14.08.2016.
 */

@Entity
@Table(name = "Games")
public class Game extends GameForTransaction{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true)
    private long id;


    @OneToMany(mappedBy="game")
    //@OrderBy("nowPlayingGame")
    private List<UserData> users;

    public List<UserData> getUsers(){
        return users;
    }

    public void setUsers(List<UserData> users){
        this.users = users;
    }


    @OneToOne
    private Map map;
    @OneToMany
    private List<Card>   cards;

    public Game(){super();}

    public Game(long id){this.id = id;}

    public Game(String name,String password){
        super(name,password);
    }

    public Game(String name,String password,boolean open){
        super(name,password,open);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString(){
        return getId() + "::" + getName() + ": " + getPassword() + " - Open: " + isOpen();
    }



    //    public game(List<User>  users, boolean open) {
//        this.users = users;
//        this.open = open;
//
//    }
//    public void addHero(Hero hero){
//        heroes.add(hero);
//    }
//    public Room openRoom(int x, int y){
//        return map.openRoom(x,y);
//    }
//    public Wall getWall(int x, int y){
//        return map.getWall(x,y);
//    }
//    public Card getCard(){;
//        //cards.add(new Card());
//        return cards.get(cards.size()-1);
//    }


}
