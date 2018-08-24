package com.ttyc.seviceLoader;

public class EurekaRegistry implements RegistryCenter{
    @Override
    public void registry() {
        System.out.println("eureka regist");
    }
}
