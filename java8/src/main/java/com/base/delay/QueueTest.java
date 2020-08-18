package com.base.delay;

import java.util.PriorityQueue;

public class QueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(32);
        queue.add(5);
        queue.add(22);
        queue.add(52);
        queue.add(91);
        Integer peek = queue.peek();
        System.out.println("peek = " + peek);
    }
}
