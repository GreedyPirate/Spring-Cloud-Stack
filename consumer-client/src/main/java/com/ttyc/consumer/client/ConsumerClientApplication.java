package com.ttyc.consumer.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerClientApplication.class, args);
	}
}
