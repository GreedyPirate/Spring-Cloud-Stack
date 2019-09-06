package com.base;

import java.util.Arrays;

public class CycleQueue<T> {

    private Object[] elements;

    /**
     * head记录头元素所在位置
     * tail 记录尾元素的下一个位置
     */
    private int head, tail;

    private static final int DEFAULT_CAPACITY = 15;

    public CycleQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CycleQueue(int capacity) {
        elements = new Object[capacity];
    }

    public void add(T t) {
        // tail的下一个如果是head，那么循环队列一定是满了
        if ((tail + 1) % elements.length == head) {
            throw new IllegalStateException("队列已满");
        }
        elements[tail] = t;

        tail = (tail + 1) % elements.length;
    }

    public T poll() {
        if (tail == head) {
            return null;
        }
        T t = (T) elements[head];
        head = (head + 1) % elements.length;
        return t;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
