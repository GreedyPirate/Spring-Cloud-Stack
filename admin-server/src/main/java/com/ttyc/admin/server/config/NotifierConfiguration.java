package com.ttyc.admin.server.config;

import de.codecentric.boot.admin.server.notify.Notifier;
import de.codecentric.boot.admin.server.notify.RemindingNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

//@Configuration
public class NotifierConfiguration {

    @Autowired
    Notifier notifier;

    @Primary
    @Bean(initMethod = "start", destroyMethod = "stop")
    public RemindingNotifier remindingNotifier() {
        RemindingNotifier remindingNotifier = new RemindingNotifier(notifier, null);
        remindingNotifier.setReminderPeriod(Duration.ofMinutes(10));
        remindingNotifier.setCheckReminderInverval(Duration.ofSeconds(10));
        return remindingNotifier;
    }
}