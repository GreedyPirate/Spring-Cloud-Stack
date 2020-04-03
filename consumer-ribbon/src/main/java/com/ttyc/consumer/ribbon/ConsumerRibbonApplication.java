package com.ttyc.consumer.ribbon;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableRetry
@EnableSwagger2Doc
public class ConsumerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerRibbonApplication.class, args);
	}
}
