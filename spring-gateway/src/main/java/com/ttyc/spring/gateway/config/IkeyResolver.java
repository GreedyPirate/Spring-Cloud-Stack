package com.ttyc.spring.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class IkeyResolver implements KeyResolver{
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return null;
    }
}
