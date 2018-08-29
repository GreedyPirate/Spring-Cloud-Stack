package com.ttyc.bitset;

import org.junit.Test;

import java.util.*;

public class Duplicate {

    private static List<Invoice> invoices = new ArrayList<>();

    static {
        for (int i = 0; i < 3000; i++) {
            Invoice invoice = new Invoice();
            invoice.setCode(randomStr());
            invoice.setNumber(randomStr());
            invoices.add(invoice);
        }
    }

    public static String randomStr(){
        StringBuilder result = new StringBuilder();
        String sources = "0123456789";
        Random rand = new Random();
        for (int j = 0; j < 6; j++) {
            result.append(sources.charAt(rand.nextInt(9)) + "");
        }
        return result.toString();
    }

    @Test
    public void testSimple() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);

        Set<Integer> set = new HashSet<>(list);
        set.forEach(System.out::println);

        Set<Invoice> invoiceSet = new HashSet<>(invoices);
        System.out.println(invoiceSet.size());
        invoiceSet.forEach(System.out::println);
    }

    @Test
    public void testBitset(){
        BitSet set = new BitSet();
    }

}
