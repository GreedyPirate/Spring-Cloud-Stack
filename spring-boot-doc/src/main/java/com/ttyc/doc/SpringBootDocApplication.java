package com.ttyc.doc;

import com.ttyc.doc.extend.event.customer.CustomEventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDocApplication.class, args)
                .getBean(CustomEventPublisher.class).publish();
	}
}
