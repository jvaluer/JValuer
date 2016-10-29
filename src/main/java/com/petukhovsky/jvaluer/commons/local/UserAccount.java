package com.petukhovsky.jvaluer.commons.local;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 7/4/2016.
 */
public class UserAccount {
    private final String login;
    private final String password;

    @JsonCreator
    public UserAccount(@JsonProperty("password") String password, @JsonProperty("login") String login) {
        if (login == null) throw new IllegalArgumentException("Login can't be null");
        this.password = password;
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
