package com.ttyc.spring.base;

import com.ttyc.spring.base.service.WhiteService;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBaseApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SpringBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DefaultSingletonBeanRegistry registry = new DefaultSingletonBeanRegistry();
		registry.registerSingleton("whiteService", new WhiteService());
	}
}
