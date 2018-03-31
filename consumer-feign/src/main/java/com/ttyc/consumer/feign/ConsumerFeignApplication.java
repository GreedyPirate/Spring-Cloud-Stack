package com.ttyc.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignApplication.class, args);
	}
}
