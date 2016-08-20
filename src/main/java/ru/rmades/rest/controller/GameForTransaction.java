package ru.rmades.rest.controller;

/**
 * Created by Администратор on 15.08.2016.
 */
public class GameForTransaction {

    private String name;
    private String password;
    private boolean open;



    public GameForTransaction(){}

    public GameForTransaction(String name, String password) {
        this();
        this.name = name;
        this.password = password;
    }

    public GameForTransaction(String name, String password, boolean open){
        this(name,password);
        this.open = open;
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

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isEmpty(){
        return name.isEmpty();
    }
}
