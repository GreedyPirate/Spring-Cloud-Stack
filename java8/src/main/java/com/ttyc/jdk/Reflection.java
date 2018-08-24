package com.ttyc.jdk;

import com.ttyc.jdk.assist.User;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    @Test
    public void testMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Method inherit = User.class.getMethod("inherit", null);
        Object result = inherit.invoke(user, null);
        boolean assignableFrom = Void.class.isAssignableFrom(result.getClass());
        System.out.println(assignableFrom);
    }
}
