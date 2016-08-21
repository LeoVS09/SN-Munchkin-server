package ru.rmades.rest.ODT.Game;

import ru.rmades.rest.ODT.UserData;
import ru.rmades.rest.controller.mobile.GameForTransaction;

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
    //private ArrayList<User>   users;
    //private ArrayList<Hero>   heroes;
    //private Map               map;
    //private ArrayList<Card>   cards;

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

    @Override
    public String toString(){
        return getId() + "::" + getName() + ": " + getPassword() + " - Open: " + isOpen();
    }



    //    public Game(ArrayList<User>  users, boolean open) {
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
