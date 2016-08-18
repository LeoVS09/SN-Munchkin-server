package ru.rmades.rest;

/**
 * Created by Администратор on 17.08.2016.
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Users")
public class UserForDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique=true)
    private String login;

    @NotNull
    private String password;

    @Override
    public String toString(){
        return getId() + "::" + getLogin() + ": " + getPassword();
    }

    public UserForDB(){}

    public UserForDB(long id){
        this.id = id;
    }

    public UserForDB(String login, String password){
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
}
