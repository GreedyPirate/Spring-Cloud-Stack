package com.ttyc.lombok;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * AccessLevel表示构造器的访问权限
 */
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class ConstructorArgs {
    private String name;
    private String sex;
}

class Test{
    public static void main(String[] args) {
        ConstructorArgs arg = new ConstructorArgs();
    }
}
