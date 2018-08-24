package com.ttyc.seviceLoader;

public class ConsulRegistry implements RegistryCenter{
    @Override
    public void registry() {
        System.out.println("consul regist");
    }
}
