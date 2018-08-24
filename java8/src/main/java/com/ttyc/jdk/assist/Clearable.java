package com.ttyc.jdk.assist;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Clearable {
}
