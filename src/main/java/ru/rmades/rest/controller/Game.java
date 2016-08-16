package ru.rmades.rest.controller;

/**
 * Created by Администратор on 15.08.2016.
 */
public class Game {
    private String name;
    private String password;

    public Game(){}

    public Game(String name, String password) {
        this.name = name;
        this.password = password;
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
}
