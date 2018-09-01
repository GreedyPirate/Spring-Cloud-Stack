package com.ttyc.doc;

import com.ttyc.doc.cache.helper.User;
import com.ttyc.doc.cache.helper.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {
    @Autowired
    UserService userService;

    @Test
    public void testCache() {
        List<User> query = userService.query();
        query.forEach(System.out::println);
    }
}
