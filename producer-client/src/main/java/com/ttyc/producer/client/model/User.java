package com.ttyc.producer.client.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {
    @NotNull
    private String username;
//    @Size(min = 18, max = 120, message = "年龄只能在18-120岁之间")
    private String age;
}