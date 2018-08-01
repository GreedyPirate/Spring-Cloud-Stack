package com.ttyc.doc;

import com.ttyc.doc.extend.event.customer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringBootDocApplication {

	public static void main(String[] args) {
		/*SpringApplication.run(SpringBootDocApplication.class, args)
                .getBean(CustomEventPublisher.class).publish();*/
//		new SpringApplicationBuilder(SpringBootDocApplication.class).listeners(new SpringBootListener()).run(args);
		SpringApplication.run(SpringBootDocApplication.class,args).addApplicationListener(new SpringBootListener());
	}
}
