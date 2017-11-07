package by.it.mustaphin.jd02_01_AND_jd02_02;

import java.util.concurrent.ConcurrentLinkedQueue;

class Market implements Runnable {

    Market() {
        Thread thread = new Thread(this);
        thread.start();
        letIn();
    }

    static ConcurrentLinkedQueue<Buyer> buyers = new ConcurrentLinkedQueue<>();

    void letIn() {
        for (int i = 0; i < 60; i++) {
            for (int k = (int) (Math.random() * 3); k > 0; k--) {
                new Buyer(i + ":" + k);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        Cashier c1 = new Cashier("Кассир 1");
    }
}
