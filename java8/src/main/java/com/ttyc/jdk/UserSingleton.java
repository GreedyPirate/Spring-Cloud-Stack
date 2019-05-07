package com.ttyc.jdk;

import com.ttyc.jdk.assist.User;

public enum UserSingleton {
    INSTANCE;

    private User user;

    UserSingleton() {
        this.user = new User();
    }

    public String showName(){
        return user.getUsername();
    }
}