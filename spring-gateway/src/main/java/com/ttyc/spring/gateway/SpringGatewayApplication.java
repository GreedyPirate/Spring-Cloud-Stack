package com.ttyc.spring.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.stream.StreamSupport;

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
    public GlobalFilter urlFilter() {
        return (exchange, chain) -> {
//            List<String> traceId = exchange.getRequest().getHeaders().get(TRACE_ID);
            ServerHttpResponse response = exchange.getResponse();
//            response.getHeaders().add(TRACE_ID, StringUtils.collectionToCommaDelimitedString(traceId));
            return chain.filter(exchange.mutate().response(response).build()).then(Mono.fromRunnable(() -> {
                String path = exchange.getRequest().getPath().pathWithinApplication().value();
                LinkedHashSet attribute =
                        exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
                Optional<String> first = StreamSupport.stream(attribute.spliterator(), false).findFirst();
                String url = first.get();

                log.info("path is {}, url is {}", path, url);
            }));
        };
    }
}
