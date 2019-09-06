package com.ttyc.consul.producer;

import com.ttyc.consul.producer.config.MyConsulAutoConfig;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.HeartbeatProperties;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistrationCustomizer;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulProducerApplication.class, args);
	}

//	@Bean
	public ConsulAutoRegistration consulRegistration(AutoServiceRegistrationProperties autoServiceRegistrationProperties,
													 ConsulDiscoveryProperties properties, ApplicationContext applicationContext,
													 ObjectProvider<List<ConsulRegistrationCustomizer>> registrationCustomizers, HeartbeatProperties heartbeatProperties) {
		return MyConsulAutoConfig.registration(autoServiceRegistrationProperties, properties,
				applicationContext, registrationCustomizers.getIfAvailable(), heartbeatProperties);
	}
}
