package com.ttyc.spring.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AccessFilter implements GlobalFilter{
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String headval = exchange.getRequest().getHeaders().getFirst("headval");
        //获取url参数值
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        //获取POST过来的值呢
        Flux<DataBuffer> body = exchange.getRequest().getBody();


        ServerHttpResponse response = exchange.getResponse();
        //设置header
        HttpHeaders httpHeaders = response.getHeaders();
        httpHeaders.add("Content-Type", "application/json;charset=UTF-8"); 
        httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        //设置body
        String bodyPackage = "{\"status\":\"110\",\"message\":\"未登录或登录超时\"}";
        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(bodyPackage.getBytes());
        //返回
        return response.writeWith(Mono.just(bodyDataBuffer));




    }
}
