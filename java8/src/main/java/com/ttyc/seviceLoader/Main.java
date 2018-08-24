package com.ttyc.seviceLoader;

import com.sun.tools.javac.util.ServiceLoader;
import org.junit.Test;


public class Main {
    @Test
    public void testServiceLoader(){
        ServiceLoader<RegistryCenter> services = ServiceLoader.load(RegistryCenter.class);
        services.forEach(service -> service.registry());
    }
}
