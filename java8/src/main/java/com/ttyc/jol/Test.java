package com.ttyc.jol;

/**
 *
 */
public class Test {

    class Node {
        int data;

        Node next;

        public Node() {
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node sort(Node firstNode) {
        Node head = new Node();
        head.next = firstNode;

        if(firstNode == null) {
           return null;
        }
        if(firstNode.next == null || firstNode.next == firstNode) {
            firstNode.next = null;
            return firstNode;
        }

        Node curr = head.next;
        Node newHead = head;
        Node node = new Node();
        node.data = curr.data;
        while (curr != null) {
            Node newNext = newHead.next;
            while (newNext != null) {
                if (node.data <= newNext.data) {
                    node.next = newNext.next;
                    newNext.next = node;
                    break;
                }
            }
            // 当前值最小
            if(newNext.next == null) {
                newNext.next = node;
            }

            curr = curr.next;

            node = new Node();
            node.data = curr.data;
        }


        return newHead.next;
    }


    public Node sort1(Node first) {
        if(first == null) {
            return null;
        }
        if(first.next == null) {
            return first;
        }

        Node head = first;
        Node pre = first;
        Node next = first.next;

        while(pre != null) {
            if(pre.data > next.data) {
                pre.next = next.next;
                next.next = pre;
            }
        }


        return null;
    }
}





















