package com.ttyc.sleuth.feign.consumer.sleuth;

import org.springframework.cloud.sleuth.SpanAdjuster;
import org.springframework.cloud.sleuth.zipkin2.ZipkinRestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerZipkinRestTemplate {

    /**
     * 自定义RestTemplate
     * @return
     */
    @Bean
    ZipkinRestTemplateCustomizer zipkinRestTemplateCustomizer(){
        return new ZipkinRestTemplateCustomizer() {
            @Override
            public void customize(RestTemplate restTemplate) {
            }
        };
    }

    /**
     * 自定义span的名称
     * @return
     */
    @Bean
    SpanAdjuster adjusterOne() {
        return span -> span.toBuilder().name("foo").build();
    }

    @Bean SpanAdjuster adjusterTwo() {
        return span -> span.toBuilder().name(span.name() + " bar").build();
    }
}
