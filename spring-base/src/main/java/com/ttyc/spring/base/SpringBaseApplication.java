package com.ttyc.spring.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBaseApplication.class, args);
	}
}
