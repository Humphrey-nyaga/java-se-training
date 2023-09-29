package com.systechafrica.pos.posreviewed;


import com.systechafrica.pos.posreviewed.logger.FileLogger;

import java.util.logging.Logger;

import static com.systechafrica.pos.posreviewed.Authentication.passwordHasher;

public class User {
    private static Logger LOGGER = FileLogger.getLogger();
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
