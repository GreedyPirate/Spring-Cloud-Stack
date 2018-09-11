package com.ttyc.spring.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class SpringGatewayApplication {

    private static final String TRACE_ID="X-B3-TraceId";

	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayApplication.class, args);
	}


    @Bean
    @Order(-1)
    public GlobalFilter filter() {
        return (exchange, chain) -> {
            List<String> traceId = exchange.getRequest().getHeaders().get(TRACE_ID);
            ServerHttpResponse response = exchange.getResponse();
            response.getHeaders().add(TRACE_ID, StringUtils.collectionToCommaDelimitedString(traceId));
            return chain.filter(exchange.mutate().response(response).build()).then(Mono.fromRunnable(() -> {
            }));
        };
    }
}
