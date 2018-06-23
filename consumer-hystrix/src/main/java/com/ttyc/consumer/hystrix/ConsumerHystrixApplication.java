package com.ttyc.consumer.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
public class ConsumerHystrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerHystrixApplication.class, args);
	}
}
