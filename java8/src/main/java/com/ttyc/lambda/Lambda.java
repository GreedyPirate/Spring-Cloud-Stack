package com.ttyc.lambda;

import org.junit.Test;

public class Lambda {
    @Test
    public void testInvoke(){

    }
}

@FunctionalInterface
interface Include{
    boolean include(String str);
}
