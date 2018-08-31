package com.ttyc.doc;

import com.ttyc.doc.cache.helper.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {
    @Autowired
    UserService userService;

    public void testCache() {

    }
}
