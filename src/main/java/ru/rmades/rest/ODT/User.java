package ru.rmades.rest.ODT;

import ru.rmades.rest.ODT.Game.Game;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Администратор on 14.08.2016.
 */


@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true)
    private long id;

    @NotNull
    @Column(unique=true)
    private String login;

    @NotNull
    private String password;

    private int pastGames;

    private int victories;


    @ManyToOne
    private Game game;

    public Game getGame(){
        return game;
    }
    public void setGame(Game game){
        this.game = game;
    }

    public User(){}

    public User(long id){
        this.id = id;
    }

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPastGames() {
        return pastGames;
    }

    public int getVictories() {
        return victories;
    }

    public int getLosses(){
        return pastGames - victories;
    }

    public void addVictory() {
        pastGames++;
        victories++;
    }

    public void addLoss(){
        pastGames++;
    }

    @Override
    public String toString(){
        return getId() + "::" + getLogin() + ": " + getPassword();
    }
}
