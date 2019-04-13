package com.ttyc.stream.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor()
public class User {

    private String name;
    private String gender;
    private Integer type;
    private Long age;

    public User(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getKey() {
        return new StringBuilder().append(name).append('-').append(gender).toString();
    }
}