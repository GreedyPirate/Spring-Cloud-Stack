package com.ttyc.admin.client.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskConfig {

    @Scheduled(cron = "*/10 * * * * ?")
    public void testTask(){
      log.debug("测试定时任务");
    }
}
