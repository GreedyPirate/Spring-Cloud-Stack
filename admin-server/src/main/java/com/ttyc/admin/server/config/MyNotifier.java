package com.ttyc.admin.server.config;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.domain.values.StatusInfo;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class MyNotifier extends AbstractStatusChangeNotifier {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public MyNotifier(InstanceRepository repositpry) {
        super(repositpry);
    }


    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {

        return Mono.fromRunnable(() -> {
            if (event instanceof InstanceStatusChangedEvent) {
                StatusInfo statusInfo = ((InstanceStatusChangedEvent) event).getStatusInfo();
                String status = statusInfo.getStatus();
                Map<String, Object> details = statusInfo.getDetails();
                String detailStr = details.toString();
                boolean isOffline = statusInfo.isOffline();
                LOGGER.info("status info are: status:{}, detail:{}, isOffline:{}", status, detailStr, isOffline);

                String mavenVersion = instance.getBuildVersion().getValue();
                String healthUrl = instance.getRegistration().getHealthUrl();
                LOGGER.info("instance build version is {}, health check url is {}", mavenVersion, healthUrl);

                // 获取事件信息，instance(客户端)信息，用来发钉钉消息，短信等等的通知
                LOGGER.info("Instance {} ({}) is {}", instance.getRegistration().getName(), event.getInstance(),
                        ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus());
            } else {
                LOGGER.info("Instance {} ({}) {}", instance.getRegistration().getName(), event.getInstance(),
                        event.getType());
            }
        });
    }
}
