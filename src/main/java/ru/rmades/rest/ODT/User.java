package ru.rmades.rest.ODT;

import ru.rmades.rest.ODT.Game.Game;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Администратор on 14.08.2016.
 */


@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true)
    private long user_id;

    @NotNull
    @Column(unique=true)
    private String login;

    @NotNull
    private String password;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="users_games", joinColumns=@JoinColumn(referencedColumnName="user_id")
            , inverseJoinColumns=@JoinColumn(referencedColumnName="game_id"))
    private Set<Game> games;

    public Set<Game> getGames(){
        return games;
    }
    public void setGames(Set<Game> games){
        this.games = games;
    }

    public User(){}

    public User(long id){
        this.user_id = id;
    }

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return user_id;
    }

    public void setId(long id) {
        this.user_id = id;
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

    @Override
    public String toString(){
        return getId() + "::" + getLogin() + ": " + getPassword();
    }
}
