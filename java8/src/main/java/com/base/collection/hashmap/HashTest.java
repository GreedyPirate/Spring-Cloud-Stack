package com.base.collection.hashmap;

public class HashTest {
    public static void main(String[] args) {
        int hash = 3614;

        int index = (16 - 1) & hash;

        System.out.println("index = " + index);

        System.out.println("length = " + Integer.toBinaryString(15));

        System.out.println("hash = " + Integer.toBinaryString(hash));

        System.out.println("index = " + hash % 15);

        System.out.println("14 = " + Integer.toBinaryString(14));

        int size = tableSizeFor(74);
        System.out.println("size = " + size);

        int spread = spread(3614);
        System.out.println("spread = " + spread);
    }


    static int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println("binary = " + Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println("n |= " + Integer.toBinaryString(n));
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1000000) ? 1000000 : n + 1;
    }

    static final int spread(int h) {
        int HASH_BITS = 0x7fffffff;
        return (h ^ (h >>> 16)) & HASH_BITS;
    }
}
