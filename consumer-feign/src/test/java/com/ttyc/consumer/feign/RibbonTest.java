package com.ttyc.consumer.feign;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RibbonTest {

    @Autowired
    Environment environment;

    @Test
    public void testRibbon(){
        String property = environment.getProperty("ribbon.client.name");
    }
}
