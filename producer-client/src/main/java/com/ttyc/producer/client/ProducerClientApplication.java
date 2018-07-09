package com.ttyc.producer.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProducerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerClientApplication.class, args);
	}
}
