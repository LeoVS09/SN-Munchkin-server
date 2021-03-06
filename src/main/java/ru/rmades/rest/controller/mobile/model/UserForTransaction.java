package ru.rmades.rest.controller.mobile.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * Created by Администратор on 15.08.2016.
 */

@MappedSuperclass
public class UserForTransaction {

    @NotNull
    @Column(unique=true)
    private String login;

    @NotNull
    private String password;

    public UserForTransaction(){}

    public UserForTransaction(String login){
        this.login = login;
    }

    public UserForTransaction(String login, String password) {
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

    public boolean isEmpty(){
        return login.isEmpty() || password.isEmpty();
    }

}
