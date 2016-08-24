package ru.rmades.rest.controller.mobile.model;

import javax.persistence.Column;
import javax.persistence.Lob;
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

    @Column(unique=true)
    @Lob
    private String token;


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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isEmpty(){
        return login.isEmpty() || password.isEmpty();
    }

    @Override
    public String toString(){
        String result = "{\n";
        result += "\"login\": \"" + getLogin() + "\"\n";
        result += "\"password\": \"" + getPassword() + "\"\n";
        result += "\"token\": \"" + getToken() + "\"\n";
        return result;
    }
}
