package ru.rmades.rest;

/**
 * Created by Администратор on 17.08.2016.
 */

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Useers")
public class User {
    @Id
    @GeneratedValue(strrategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String login;

    @NotNull
    private String password;

    public User(){}

    public User(long id){
        this.id = id;
    }

    public User(String login,String password){
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
