package ru.rmades.rest.ODT;

import ru.rmades.rest.ODT.Game.Creatures.Hero;
import ru.rmades.rest.ODT.Game.Game;
import ru.rmades.rest.controller.mobile.model.UserForTransaction;

import javax.persistence.*;

/**
 * Created by Администратор on 14.08.2016.
 */


@Entity
@Table(name = "Users")
public class UserData extends UserForTransaction{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true)
    private long id;

    private int pastGames;

    private int victories;

    @OneToOne
    private Hero hero;

    @ManyToOne
    private Game game;

    public Game getGame(){
        return game;
    }
    public void setGame(Game game){
        this.game = game;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public UserData(){super();}

    public UserData(long id){
        this.id = id;
    }

    public UserData(String login, String password){
        super(login,password);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
