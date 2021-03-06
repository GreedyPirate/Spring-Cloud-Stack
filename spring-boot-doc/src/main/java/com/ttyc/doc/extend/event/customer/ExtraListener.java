package com.ttyc.doc.extend.event.customer;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ExtraListener implements ApplicationListener<CustomerEvent> {
    @Override
    public void onApplicationEvent(CustomerEvent event) {
        System.out.println("ExtraListener listening： CustomerEvent has been triggered, event name is " + event.getName());
    }
}
