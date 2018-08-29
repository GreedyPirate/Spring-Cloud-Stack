package com.ttyc.consumer.feign;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.ttyc.consumer.feign.service.SideCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2Doc
@RestController
public class ConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignApplication.class, args);
	}

	@Autowired
	SideCarService sideCarService;

	@GetMapping("php-test")
	public String sidecar(){
		return this.sideCarService.health();
	}
}
