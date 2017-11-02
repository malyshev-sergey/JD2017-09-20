package by.it.shelkovich.jd2_02;

public class CashierDispatcher extends Thread {
    @Override
    public void run() {
        Cashier[] cashiers = new Cashier[5];
        for (int i = 0; i < 5; i++) {
            cashiers[i] = new Cashier(i + 1);
            cashiers[i].start();
        }

        int cashierCount = 0;
        while (!Thread.interrupted()) {
            int buyersCount = BuyerQueue.pensQueue.size() + BuyerQueue.queue.size();
            //System.err.println("buyers count: " + buyersCount);
            //System.err.println("cashiers count: " + cashierCount);
            int cashierPlan = buyersCount / 5;
            if (buyersCount % 5 != 0) cashierPlan++;
            if (cashierPlan > 5) cashierPlan = 5;

            if (cashierPlan > cashierCount) {
                for (int i = cashierCount; i < cashierPlan; i++) {
                    cashiers[i].setPaused(false);
                    synchronized (cashiers[i]) {
                        if (cashiers[i].getState() == State.WAITING)
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
