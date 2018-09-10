package com.ttyc.admin.server.config;

import de.codecentric.boot.admin.server.web.client.HttpHeadersProvider;
import de.codecentric.boot.admin.server.web.client.InstanceExchangeFilterFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;


@Configuration
public class CustomerConfig {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    public HttpHeadersProvider customHttpHeadersProvider() {
        return  instance -> {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("X-CUSTOM", "My Custom Value");
            return httpHeaders;
        };
    }

    @Bean
    public InstanceExchangeFilterFunction auditLog() {
        return (instance, request, next) -> {
            if (HttpMethod.DELETE.equals(request.method()) || HttpMethod.POST.equals(request.method())) {
                log.info("{} for {} on {}", request.method(), instance.getId(), request.url());
            }
            return next.exchange(request);
        };
    }
}
