package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class X {
  private final Lock rtl = new ReentrantLock();
  int value;
  public void addOne() {
    // 获取锁
    rtl.lock();  
    try {
      value+=1;
    } finally {
      // 保证锁能释放
      rtl.unlock();
    }
  }

  public static void main(String[] args) {
    X x = new X();
    for (int i = 0; i < 1000; i++) {
      x.addOne();
    }
    System.out.println(x.value);
    Lock lock = new ReentrantLock();
    lock.lock();
    lock.unlock();
  }
}