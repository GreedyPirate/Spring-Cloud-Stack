package com.ttyc.sleuth.sleuth.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class SleuthProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuthProducerApplication.class, args);
	}

	@GetMapping("/getInfo")
	public String provide(){
		return "producer";
	}
}
