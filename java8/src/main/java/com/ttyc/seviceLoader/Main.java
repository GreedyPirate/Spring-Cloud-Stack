package com.ttyc.seviceLoader;

import com.sun.tools.javac.util.ServiceLoader;


public class Main {
    public static void main(String[] args) {
        ServiceLoader<RegistryCenter> services = ServiceLoader.load(RegistryCenter.class);
        services.forEach(service -> service.registry());
    }
}
