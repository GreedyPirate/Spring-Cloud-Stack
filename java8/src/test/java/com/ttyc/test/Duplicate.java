package com.ttyc.test;

public class Duplicate {
    public static void main(String[] args) {
        if(getStr().length() > 0 && getStr().contains("tt")){
            System.out.println(getStr());
        }
    }

    public static String getStr(){
        System.out.println("invoked");
        return "ttyc";
    }
}
