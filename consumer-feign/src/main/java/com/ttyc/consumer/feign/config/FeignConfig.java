package com.ttyc.consumer.feign.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {
    /**
     * 重试间隔为100ms，最大重试时间为1s,重试次数为3次。
     * @return
     */
    @Bean
    Retryer retryConfig(){
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1),4);
    }
}
