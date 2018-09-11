package com.ttyc.doc.extend.runner;

import org.springframework.boot.CommandLineRunner;

/**
 * CommandLineRunner和ApplicationRunner类似，多个必须加@Order
 *
 * @author yangjie
 * @since 1.0.0
 * @createTime 2018/7/31
 */
//@Component
public class RunnerBean implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        for(String arg:args){
            System.out.println(arg);
        }
    }
}