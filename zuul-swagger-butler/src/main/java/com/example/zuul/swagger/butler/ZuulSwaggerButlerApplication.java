package com.example.zuul.swagger.butler;

import com.didispace.swagger.butler.EnableSwaggerButler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwaggerButler
public class ZuulSwaggerButlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulSwaggerButlerApplication.class, args);
	}
}
