package com.systechafrica.pos.posreviewed;

import static com.systechafrica.pos.posreviewed.Utils.passwordHasher;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password =  passwordHasher(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
