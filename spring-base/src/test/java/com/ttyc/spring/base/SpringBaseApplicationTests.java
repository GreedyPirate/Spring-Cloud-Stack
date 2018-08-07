package com.ttyc.spring.base;

import com.ttyc.spring.base.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBaseApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
		Boolean regist = userService.regist();

	}

}
