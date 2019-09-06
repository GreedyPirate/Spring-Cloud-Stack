package com.base;

/**
 * 使用链表实现的队列
 * 维护尾指针，使用尾插发，O(1), 然后出头结点
 */
public class LinkedQueue<T> {

    private Node<T> head;

    private Node<T> tail;

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {}

        public Node(T data) {
            this.data = data;
        }
    }

    public LinkedQueue() {
        head = new Node<>();
        tail = head;
    }

    public void add(T t) {
        Node<T> node = new Node<>(t);
        tail.next = node;
    }

    public T poll() {
        if(head.next == null) {
            return null;
        }
        Node<T> second = head.next.next;
        T data = head.next.data;
        head.next = second;
        return data;
    }

    @Override
    public String toString() {
        if(head.next == null) {
            return "";
        }
        Node<T> node = head.next;
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.data.toString()).append(",");
            node = node.next;
        }
        return builder.toString();
    }
}
