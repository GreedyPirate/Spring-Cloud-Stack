package com.ttyc.jdk.assist;

@Clearable
public class SuperUser extends User{

    private static String role = "admin";

    public SuperUser(){
        System.out.println("super init");
    }

    @Override
    public void talk() {
        System.out.println("super user ...");
    }
}
