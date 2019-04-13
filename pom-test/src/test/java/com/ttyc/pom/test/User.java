package com.ttyc.pom.test;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String name;
    private Integer age;
}
