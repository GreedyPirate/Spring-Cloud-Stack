package com.ttyc.doc.extend.event.customer;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

public class CustomerEvent extends ApplicationEvent{

    private String name;

    public CustomerEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
