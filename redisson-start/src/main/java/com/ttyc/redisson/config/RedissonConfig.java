package com.ttyc.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class RedissonConfig {

    @Bean
    RedissonClient redissonSingle() {
        Config config = new Config();
        String address = "redis://localhost:6379";
        config.setThreads(Math.max(Runtime.getRuntime().availableProcessors()*2,8))
                .setNettyThreads(Math.max(Runtime.getRuntime().availableProcessors()*2,16))
                .useSingleServer()
                .setAddress(address)
                .setConnectTimeout(2000)
                .setConnectionMinimumIdleSize(16)
                .setConnectionPoolSize(64)
                .setSubscriptionConnectionMinimumIdleSize(1)
                .setSubscriptionConnectionPoolSize(2);
        config.setCodec(new StringCodec());

        return Redisson.create(config);
    }
}
