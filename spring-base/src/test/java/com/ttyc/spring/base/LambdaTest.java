package com.ttyc.spring.base;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaTest {
    @Test
    public void test(){
        List<String> names = new ArrayList<>();
        names.add("d");
        names.add("r");
        names.add("a");
        Collections.sort(names,(a,b)-> a.compareTo(b));
        System.out.println(names);
    }

    @Test
    public void testReg(){
        String reg = "\\d{3}";
        String number = "123";
        Assert.assertTrue(number.matches(reg));
    }

    @Test
    public void testMavenInstall() {
        String filename = "ehcache-core-2.4.4.jar";
        String groupname = "net.sf.ehcache";
        String artifactname = "ehcache-core";
        String version = "2.4.4";
        StringBuilder sb = new StringBuilder();
        sb.append("mvn install:install-file -Dfile=/Users/admin/Downloads/").append(filename).append(" -DgroupId=").append(groupname)
                .append(" -DartifactId=").append(artifactname).append(" -Dversion=").append(version).append(" -Dpackaging=jar");
        System.out.println(sb.toString());
    }
}

