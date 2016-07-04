package com.petukhovsky.jvaluer.commons.local;

/**
 * Created by Arthur Petukhovsky on 7/4/2016.
 */
public class UserAccount {
    private final String login;
    private final String password;

    public UserAccount(String password, String login) {
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
