package com.ttyc.sleuth.feign.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class SleuthFeignProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuthFeignProducerApplication.class, args);
	}
}
