package com.ttyc.doc.extend.lifecycle;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 *
 * 很无聊的类，就是说给System.exit()指定status
 * System.exit(SpringApplication.exit(SpringApplication.run(SpringBootDocApplication.class,args)));
 * @author yangjie
 * @since 1.0.0
 * @createTime 2018/8/10
 */
@Component
public class ExitStatus implements ExitCodeGenerator {
    @Override
    public int getExitCode() {
        return -1;
    }
}
