package com.ttyc.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AdminStaticServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminStaticServerApplication.class, args);
	}
}
