package com.ttyc.sleuth.feign.consumer.sleuth;

import brave.http.HttpAdapter;
import brave.http.HttpSampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.web.ClientSampler;
import org.springframework.cloud.sleuth.instrument.web.ServerSampler;
import org.springframework.cloud.sleuth.instrument.web.SkipPatternProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Pattern;

/**
 * 条件采样
 */
@Configuration
class Config {
    @Autowired @ClientSampler
    HttpSampler httpSampler;


    @Bean(name = ServerSampler.NAME)
    HttpSampler myHttpSampler(SkipPatternProvider provider) {
        Pattern pattern = provider.skipPattern();
        return new HttpSampler() {

            @Override
            public <Req> Boolean trySample(HttpAdapter<Req, ?> adapter, Req request) {
                String requestUrl = adapter.url(request);
                String method = adapter.method(request);
                String header = adapter.requestHeader(request, "x-php");
                String url = adapter.path(request);
                /*boolean shouldSkip = pattern.matcher(url).matches();
                if (shouldSkip) {
                    return false;
  			    }*/
                if (header.contains("php")) {
                    return false;
                }
                return null;
            }
        };
    }
}