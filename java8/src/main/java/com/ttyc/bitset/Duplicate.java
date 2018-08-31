package com.ttyc.bitset;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Duplicate {

    List<Invoice> invoices = new ArrayList<>();

    @Before
    public void init(){
        invoices.add(new Invoice("100000","200000"));
        invoices.add(new Invoice("100000","200000"));
        invoices.add(new Invoice("100001","200000"));
        invoices.add(new Invoice("100000","200001"));
        invoices.add(new Invoice("100001","200001"));
    }

    @Test
    public void testSimple() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);

        Set<Integer> set = new HashSet<>(list);
        set.forEach(System.out::println);
    }

    @Test
    public void testField() {
        List<Invoice> ret = invoices.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getCode() + ";" + o.getNumber()))), ArrayList::new));
        ret.forEach(System.out::println);
    }

}
