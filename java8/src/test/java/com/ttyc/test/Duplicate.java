package com.ttyc.test;

import com.ttyc.jdk.assist.Car;

public class Duplicate {

    private Integer i = 0;

    public static void main(String[] args) {
        if(getStr().length() > 0 && getStr().contains("tt")){
            System.out.println(getStr());
        }
        Car car = new Car();
        Duplicate duplicate = new Duplicate();
        Car ret = param(car, duplicate);
        System.out.println(duplicate.getI());
    }

    public static String getStr(){
        System.out.println("invoked");
        return "ttyc";
    }


    public static Car param(Car car, Duplicate duplicate) {
        duplicate.setI(20);
        car.setColor("blue");
        return car;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}
