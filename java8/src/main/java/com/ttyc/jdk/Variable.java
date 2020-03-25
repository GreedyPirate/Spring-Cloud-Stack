package com.ttyc.jdk;

public class Variable {

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void find() {
        reduce(size);
    }

    private int reduce(int var) {
        while (var > 0) {
            var--;
        }
        return 0;
    }

    public static void main(String[] args) {
        Variable variable = new Variable();
        variable.setSize(10);
        variable.find();
        System.out.println(variable.getSize());
    }
}
