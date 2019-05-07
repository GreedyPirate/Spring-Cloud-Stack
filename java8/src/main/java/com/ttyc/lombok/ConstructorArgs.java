package com.ttyc.lombok;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * AccessLevel表示构造器的访问权限
 *
 * onConstructor_ 给构造器添加注解
 * @NotBlank
 * private ConstructorArgs() {
 *
 * }
 */
//@RequiredArgsConstructor(access = AccessLevel.PUBLIC, staticName = "getInstance"/*, onConstructor_={@NotBlank}*/)
@Accessors(chain = true)
@Data
public class ConstructorArgs {
    private String name;
    private String sex;
}

class Test{
    public static void main(String[] args) {
        new ConstructorArgs().setName("ds").setSex("ds");
    }
}
