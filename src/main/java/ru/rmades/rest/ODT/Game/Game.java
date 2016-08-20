package ru.rmades.rest.ODT.Game;

import ru.rmades.rest.ODT.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Администратор on 14.08.2016.
 */

@Entity
@Table(name = "Games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true)
    private long id;

    @NotNull
    @Column(unique=true)
    private String name;

    @NotNull
    private String password;

    @NotNull
    private boolean   open;

    @OneToMany(mappedBy="game")
    //@OrderBy("nowPlayingGame")
    private List<User> users;

    public List<User> getUsers(){
        return users;
    }

    public void setUsers(List<User> users){
        this.users = users;
    }
    //private ArrayList<User>   users;
    //private ArrayList<Hero>   heroes;
    //private Map               map;
    //private ArrayList<Card>   cards;

    public Game(){}

    public Game(long id){this.id = id;}

    public Game(String name,String password){
        this.name = name;
        this.password = password;
    }
    public Game(String name,String password,boolean open){
        this.name = name;
        this.password = password;
        this.open = open;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen(){
        return open;
    }

    @Override
    public String toString(){
        return id + "::" + name + ": " + password + " - Open: " + open;
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
