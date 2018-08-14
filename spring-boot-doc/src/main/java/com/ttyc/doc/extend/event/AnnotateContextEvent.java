package com.ttyc.doc.extend.event;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//@Component
public class AnnotateContextEvent{
    @EventListener
    public void handleRefresh(ContextRefreshedEvent event){
        System.out.println("Spring Refreshed by annotated approach");
    }
}
