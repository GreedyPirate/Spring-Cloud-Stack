package com.ttyc.jdk.assist;


import lombok.Data;

@Data
@Flexable
public class User implements Person {

    private String username;

    public User(String username) {
        this.username = username;
    }

    public User() {
    }

    @Override
    public void talk() {
        System.out.println("user ...");
    }

    public void inherit(){
        System.out.println("give to u");
    }

    public static class Inner{}
}
