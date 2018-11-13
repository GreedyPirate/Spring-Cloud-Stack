package com.ttyc.jdk.assist;

import lombok.ToString;

@ToString
public class Car {
    private String color = "red";

    public String getColor() {
        return color;
    }
}
