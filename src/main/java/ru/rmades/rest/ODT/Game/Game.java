package ru.rmades.rest.ODT.Game;

import ru.rmades.rest.ODT.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Администратор on 14.08.2016.
 */

@Entity
@Table(name = "Games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true)
    private long game_id;

    @NotNull
    @Column(unique=true)
    private String name;

    @NotNull
    private String password;

    @NotNull
    private boolean   open;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="games")
    private Set<User> users;

    public Set<User> getUsers(){
        return users;
    }

    public void setUsers(Set<User> users){
        this.users = users;
    }
    //private ArrayList<User>   users;
    //private ArrayList<Hero>   heroes;
    //private Map               map;
    //private ArrayList<Card>   cards;

    public Game(){}

    public Game(long id){this.game_id = id;}

    public Game(String name,String password){
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return game_id;
    }

    public void setId(long id) {
        this.game_id = id;
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
    boolean isOpen(){
        return open;
    }

}
