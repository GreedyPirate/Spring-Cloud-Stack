package com.ttyc.spring.gateway;

import com.ttyc.spring.gateway.config.IkeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayApplication.class, args);
	}

	@Bean
	public KeyResolver iKeyResolver(){
		return new IkeyResolver();
	}
}
