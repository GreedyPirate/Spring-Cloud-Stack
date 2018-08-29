package com.ttyc.spring.base;

import com.ttyc.spring.base.service.RegistryService;
import com.ttyc.spring.base.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBaseApplicationTests {

	@Autowired
	UserService userService;

	@Autowired
	List<RegistryService> registryServices;

	@Test
	public void contextLoads() {
		Boolean regist = userService.regist();
	}

	@Test
	public void testCommit(){
		userService.commit();
	}

	@Test
	public void testInject(){
		registryServices.forEach(registryService -> registryService.registry());
	}
}

