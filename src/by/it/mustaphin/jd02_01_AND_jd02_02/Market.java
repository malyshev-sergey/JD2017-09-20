package by.it.mustaphin.jd02_01_AND_jd02_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Market extends ArrayList implements Runnable {

    Market() {
        Thread thread = new Thread(this);
        thread.start();
    }

    static Queue<Buyer> buyersQueue = new LinkedList<>();

    void letIn() {
        for (int i = 0; i < 60; i++) {
            for (int k = (int) (Math.random() * 3); k > 0; k--) {
                add(new Buyer(i + ":" + k));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void moveToQueue(Buyer buyer) {
        synchronized (buyersQueue) {
            buyersQueue.offer(buyer);
        }
    }

    Cashier c1 = new Cashier("Кассир 1");
    Cashier c2 = new Cashier("Кассир 2");
    Cashier c3 = new Cashier("Кассир 3");
    Cashier c4 = new Cashier("Кассир 4");
    Cashier c5 = new Cashier("Кассир 5");

    void toService() {
        while (buyersQueue.size() > 0) {
            c1.toHandle(buyersQueue.poll());
        }
    }

    @Override
    public void run() {
        while (true) {
            if (buyersQueue.size() > 5) {

            }
        }
    }
}
