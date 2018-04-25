package com.ttyc.sleuth.sleuth.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SleuthConsumerApplication {

	@Autowired
	RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SleuthConsumerApplication.class, args);
	}


	@GetMapping("/consumer")
	public String invoke(){
		return this.restTemplate.getForObject("http://sleuth-producer:8107/getInfo",String.class);
	}
}
