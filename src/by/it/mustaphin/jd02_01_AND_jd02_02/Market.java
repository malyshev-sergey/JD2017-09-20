package by.it.mustaphin.jd02_01_AND_jd02_02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

class Market implements Runnable {

    Market() {
        Thread thread = new Thread(this);
        thread.start();
        letIn();
    }

    static LinkedBlockingQueue<Buyer> buyers = new LinkedBlockingQueue<>(30);
    List<Cashier> cashiers = new ArrayList<>();

    void letIn() {
        for (int i = 0; i < 60; i++) {
            for (int k = (int) (Math.random() * 3); k > 0; k--) {
                boolean pensioneer = false;
                if (((Math.random() * 10) + 1) <= 2.5) {
                    pensioneer = true;
                }
                new Buyer(i + ":" + k, pensioneer);
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
        for (int i = 0; i < 5; i++) {
            cashiers.add(new Cashier("Кассир " + (i + 1)));
        }
        while (true) {
            if (buyers.size() > 0) {
                synchronized (cashiers.get(0)) {
                    cashiers.get(0).notify();
                }
            } else {
                cashiers.get(0).canClose = true;
            }
            if (buyers.size() > 5) {
                synchronized (cashiers.get(1)) {
                    cashiers.get(1).notify();
                }
            } else {
                cashiers.get(1).canClose = true;
            }
            if (buyers.size() > 10) {
                synchronized (cashiers.get(2)) {
                    cashiers.get(2).notify();
                }
            } else {
                cashiers.get(2).canClose = true;
            }
            if (buyers.size() > 15) {
                synchronized (cashiers.get(3)) {
                    cashiers.get(3).notify();
                }
            } else {
                cashiers.get(3).canClose = true;
            }
            if (buyers.size() > 20) {
                synchronized (cashiers.get(4)) {
                    cashiers.get(4).notify();
                }
            } else {
                cashiers.get(4).canClose = true;
            }
        }
    }
}
