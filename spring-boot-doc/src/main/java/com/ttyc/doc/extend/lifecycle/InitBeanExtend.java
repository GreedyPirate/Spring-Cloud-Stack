package com.ttyc.doc.extend.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class InitBeanExtend implements InitializingBean,DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set");
    }

    public void init(){
        System.out.println("bean inited");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("gracefully close applicationContext");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("在初始化之后");
    }

    @PreDestroy
    public void preDestory(){
        System.out.println("在销毁之前");
    }
}
