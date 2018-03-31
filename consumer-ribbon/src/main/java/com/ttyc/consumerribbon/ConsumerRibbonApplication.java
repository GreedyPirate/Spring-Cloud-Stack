package com.ttyc.consumerribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerRibbonApplication.class, args);
	}
}
