package com.ttyc.spring.base;

import com.ttyc.spring.base.util.async.AfterCommitExecutor;
import com.ttyc.spring.base.util.async.AfterCommitExecutorImpl;
import org.junit.Test;
import org.springframework.core.ResolvableType;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class SpringToolsTest {

    private HashMap<Integer, List<String>> myMap;

    private int[] arr;

    public Set<Map<String, Integer>> foo(List<Integer> list) {
        return null;
    }

    @Test
    public void testResolvableType() throws NoSuchFieldException {

        ResolvableType t = ResolvableType.forField(getClass().getDeclaredField("myMap"));

        // java.util.AbstractMap<K, V>
        ResolvableType superType = t.getSuperType();
        System.out.println("superType = " + superType.getType());

        // java.util.Map<java.lang.Integer, java.util.List<java.lang.String>>
        ResolvableType resolvableType = t.asMap();
        System.out.println("resolvableType = " + resolvableType);

        // java.lang.Integer
        Class<?> resolve = t.getGeneric(0).resolve();
        System.out.println("resolve = " + resolve.getName());

        // java.util.List
        Class<?> resolve1 = t.getGeneric(1).resolve();
        System.out.println("resolve1 = " + resolve1.getName());

        // java.util.List<java.lang.String>
        ResolvableType generic = t.getGeneric(1);
        System.out.println("generic = " + generic.getType());

        // java.lang.String
        Class<?> aClass = t.resolveGeneric(1, 0);
        System.out.println("aClass = " + aClass.getName());

    }

    @Test
    public void testResolveArray() throws NoSuchFieldException {
        ResolvableType t = ResolvableType.forField(getClass().getDeclaredField("arr"));
        ResolvableType resolvableType = ResolvableType.forArrayComponent(t);
        String name = resolvableType.resolve().getName();
        System.out.println("name = " + name);
    }

    @Test
    public void testImpl() {
        ResolvableType resolvableType = ResolvableType.forClass(AfterCommitExecutor.class, AfterCommitExecutorImpl.class);
        String name = resolvableType.resolve().getName();
        System.out.println("name = " + name);
    }

    @Test
    public void testMethod() {
        Method[] methods = getClass().getDeclaredMethods();
        Method foo = methods[0];
        ResolvableType resolvableType = ResolvableType.forMethodParameter(foo, 0);
        String typeName = resolvableType.getGeneric(0).resolve().getTypeName();
        System.out.println("Method Parameter typeName = " + typeName);

        ResolvableType resolvableType1 = ResolvableType.forMethodReturnType(foo);
        String returnType = resolvableType1.resolve().getName();
        System.out.println("returnType = " + returnType);
        ResolvableType[] generics = resolvableType1.getGenerics();
        for (ResolvableType r : generics) {
            System.out.println("r = " + r.resolve().getName());
        }
    }

    @Test
    public void testResourceSearch() throws IOException {
        Enumeration<URL> urls = ClassLoader.getSystemResources("config/user.properties");
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            UrlResource resource = new UrlResource(url);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            for (Map.Entry<?, ?> entry : properties.entrySet()) {
                List<String> factoryClassNames = Arrays.asList(
                        StringUtils.commaDelimitedListToStringArray((String) entry.getValue()));
                System.out.println("Key = " + (String) entry.getKey() + "   value = " +  entry.getValue());
                System.out.println("factoryClassNames = " + factoryClassNames);
            }
        }
    }
}
