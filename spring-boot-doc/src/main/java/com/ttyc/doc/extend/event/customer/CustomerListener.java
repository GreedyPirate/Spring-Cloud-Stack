package com.ttyc.doc.extend.event.customer;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CustomerListener implements ApplicationListener<CustomerEvent>{
    @Override
    public void onApplicationEvent(CustomerEvent event) {
        System.out.println("CustomerListener listening： CustomerEvent has been triggered, event name is " + event.getName());
    }
}
