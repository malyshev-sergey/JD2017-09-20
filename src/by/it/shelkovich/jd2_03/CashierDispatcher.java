package by.it.shelkovich.jd2_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CashierDispatcher extends Thread {
    static AtomicInteger buyersServiced = new AtomicInteger(0);

    @Override
    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Cashier[] cashiers = new Cashier[5];
        for (int i = 0; i < 5; i++) {
            cashiers[i] = new Cashier(i + 1);
            executor.submit(cashiers[i]);
        }
        executor.shutdown();

        int cashierCount = 0;
        while (!Thread.interrupted()) {
            int buyersCount = BuyerQueue.getSize();
            //System.err.println("buyers count: " + buyersCount);
            //System.err.println("cashiers count: " + cashierCount);
            int cashierPlan = buyersCount / 5;
            if (buyersCount % 5 != 0) cashierPlan++;
            if (cashierPlan > 5) cashierPlan = 5;
            //System.err.println("cashiers plan: " + cashierPlan);

            if (cashierPlan > cashierCount) {
                for (int i = cashierCount; i < cashierPlan; i++) {
                    cashiers[i].setPaused(false);
                    synchronized (cashiers[i]) {
                        cashiers[i].notify();
                    }
                }
            } else {
                for (int i = cashierPlan; i < cashierCount; i++) {
                    cashiers[i].setPaused(true);
                }
            }
            cashierCount = cashierPlan;
            Util.sleep(100);
        }
    }
}
