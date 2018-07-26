package com.ttyc.doc.extend;

import org.springframework.beans.factory.InitializingBean;

public class InitBeanExtend implements InitializingBean{

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set");
    }

    public void init(){
        System.out.println("bean inited");
    }
}
