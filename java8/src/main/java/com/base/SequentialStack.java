package com.base;

public class SequentialStack<T> {

    private Object[] elements;

    private int top;

    private static final int DEFAULT_CAPACITY = 15;

    public SequentialStack() {
        this(DEFAULT_CAPACITY);
        top = -1;
    }

    public SequentialStack(int capacity) {
        elements = new Object[capacity];
    }

    public void push(T t) {
        if(top == elements.length-1) {
            throw new IllegalArgumentException("already full");
        }
        elements[++top] = t;
    }

    public T pop() {
        if(top == -1) {
            throw new IllegalArgumentException("empty");
        }
        return (T) elements[top--];
    }

}
