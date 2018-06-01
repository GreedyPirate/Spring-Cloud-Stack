package com.ttyc.mq.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MqUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqUserApplication.class, args);
	}
}
