package com.ttyc.spring.cloud.doc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCloudDocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDocApplication.class, args);
		ApplicationContext parent = new SpringApplicationBuilder().run(args).getParent();
	}
}
