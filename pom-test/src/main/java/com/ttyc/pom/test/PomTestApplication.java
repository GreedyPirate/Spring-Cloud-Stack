package com.ttyc.pom.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PomTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PomTestApplication.class, args);
	}

	@GetMapping("/ok")
	public String health(){
		return "ok";
	}
}
