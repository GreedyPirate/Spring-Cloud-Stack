package com.ttyc.doc.extend.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner和ApplicationRunner类似，多个必须加@Order
 *
 * @author yangjie
 * @since 1.0.0
 * @createTime 2018/7/31
 */
@Component
@Profile("dev")
public class RunnerBean implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        System.out.println(args);
    }
}