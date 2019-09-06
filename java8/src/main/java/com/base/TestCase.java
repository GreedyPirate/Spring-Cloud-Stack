package com.base;

public class TestCase {
    public static void main(String[] args) {
        CycleQueue<Integer> queue = new CycleQueue<>(5);
        queue.add(2);
        queue.add(4);
        queue.add(6);
        queue.add(8);
//        queue.add(10);

        System.out.println(queue);

        Integer i1 = queue.poll();
        System.out.println("i1 = " + i1);
        Integer i2 = queue.poll();
        System.out.println("i2 = " + i2);
        Integer i3 = queue.poll();
        System.out.println("i3 = " + i3);
        Integer i4 = queue.poll();
        System.out.println("i4 = " + i4);
        Integer i5 = queue.poll();
        System.out.println("i5 = " + i5);
    }
}
