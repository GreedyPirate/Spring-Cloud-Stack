package com.ttyc.doc.extend.event.customer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerListener implements ApplicationListener<CustomerEvent>{
    @Override
    public void onApplicationEvent(CustomerEvent event) {
        System.out.println("CustomerListener listening： CustomerEvent has been triggered, event name is " + event.getName());
    }
}
