package com.base.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {

    }
}

class Sync{

    private int num;

    public void add () {
        ReentrantLock lock = new ReentrantLock();
        try{
            lock.lock();
            num++;
        }finally {
            lock.unlock();
        }

    }
}