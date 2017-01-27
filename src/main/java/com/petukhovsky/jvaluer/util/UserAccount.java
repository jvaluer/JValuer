package com.petukhovsky.jvaluer.util;

/**
 * Created by Arthur Petukhovsky on 7/4/2016.
 */
public class UserAccount {
    private final String login;
    private final String password;

    public UserAccount(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
