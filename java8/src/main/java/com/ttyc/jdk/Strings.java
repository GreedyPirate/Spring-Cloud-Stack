package com.ttyc.jdk;

import org.junit.Test;

public class Strings {

    @Test
    public void testIntern() {
        String s1 = new String("jay");
        String internS1 = s1.intern();

        String s2 = "jay";
        System.out.println(s1 == s2);
        System.out.println(s2 == internS1);
        System.out.println(s1 == internS1);
    }
}
