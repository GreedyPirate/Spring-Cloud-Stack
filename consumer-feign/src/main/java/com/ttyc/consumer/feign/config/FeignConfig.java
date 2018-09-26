package com.ttyc.consumer.feign.config;

import feign.Retryer;
import org.springframework.cloud.sleuth.instrument.web.client.feign.NeverRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

/**
 * https://github.com/spring-cloud/spring-cloud-netflix/issues/467
 * feign重试不推荐
 */
//@Configuration
public class FeignConfig {
    /**
     * 重试间隔为100ms，最大重试时间为1s,重试次数为3次。
     *
     * @return
     */
    @Deprecated
    Retryer retryCustomer() {
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 4);
    }

    @Primary
    @Bean
    Retryer retryConfig() {
        return new NeverRetry();
    }
}
