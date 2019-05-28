package com.ttyc.thread.chapter1;

public class SyncTicket {

    public static void main(String[] args) {

        TicketHandler window = new TicketHandler();

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);

        t1.start();
        t2.start();
    }
}

class TicketHandler implements Runnable {

    private int total = 100;

    @Override
    public void run() {
        synchronized (this) {
            while (total > 0) {
                total --;
                System.out.println("售出一张，余票为 = " + total);
            }
        }
    }
}
