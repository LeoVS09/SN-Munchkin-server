package ru.rmades.rest.ODT;

import ru.rmades.rest.ODT.Game.Game;

import java.util.ArrayList;

/**
 * Created by Администратор on 14.08.2016.
 */
public class User {
    String login;
    String password;
    ArrayList<Game> games;

    public User(String login,String password) {
        this.login = login;
        this.password = password;
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

    public boolean newGame(){
        return true;
    }
}
