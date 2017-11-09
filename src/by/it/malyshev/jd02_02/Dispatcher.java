package by.it.malyshev.jd02_02;

import java.util.*;

class Dispatcher implements Runnable {

    static final Integer planBuyer = 120;

    volatile static int countBuyer = 0;
    volatile static double totalStoreRevenue = 0;

    private static final int basketsQuant = 30;
    private static List<Integer> waitingCashiers = new ArrayList<>();
    private static List<Integer> workingCashiers = new ArrayList<>();

    private static Cashier[] cashiers = new Cashier[5];


    static int getWorkingCashiers() {
        return workingCashiers.size();
    }

    private static Comparator<Buyer> pensionerComparator = (b1, b2) -> {
        if (b1.isPensioner() == b2.isPensioner()) return 0;
        else if (b1.isPensioner() && !b2.isPensioner()) return -1;
        return 1;
    };

    static final PriorityQueue<Buyer> buyerQueue = new PriorityQueue<>(5, pensionerComparator);


    @Override
    public void run() {

        for (int i = 0; i < basketsQuant; i++) {
            Basket.baskets.add(new Basket(i + 1));
        }

        Thread[] cashierThreads = new Thread[5];
        for (int i = 0; i < cashierThreads.length; i++) {
            cashiers[i] = new Cashier(i + 1);
            cashierThreads[i] = new Thread(cashiers[i]);
            cashierThreads[i].start();
        }


        Helper.sleep(1000);
        while (Buyer.buyersIn.size() != 0) {
            cashiersAdministrate();
            Helper.sleep(300);
        }
        for (Cashier cashier : cashiers) {
            cashier.setShouldCloseCashbox(false);
            synchronized (cashier) {
                cashier.notify();
            }
        }

    }


    private static void cashiersAdministrate() {
        cashiersState();

        int needCashiers;

        if (buyerQueue.size() <= 5) {
            needCashiers = 1;
        } else if (buyerQueue.size() <= 10) {
            needCashiers = 2;
        } else if (buyerQueue.size() <= 15) {
            needCashiers = 3;
        } else if (buyerQueue.size() <= 20) {
            needCashiers = 4;
        } else {
            needCashiers = 5;
        }
        if (workingCashiers.size() < needCashiers) {
            openCashier();
        } else if (workingCashiers.size() > needCashiers) {
            closeCashier();
        }

    }

    private static void cashiersState() {
        workingCashiers.clear();
        waitingCashiers.clear();
        for (int i = 0; i < cashiers.length; i++) {
            if (cashiers[i].isShouldCloseCashbox()) {
                waitingCashiers.add(i);
            } else {
                workingCashiers.add(i);
            }
        }
    }


    private static int selectCashier(boolean needWaiting) {
        if (needWaiting) {
            return waitingCashiers.get(Helper.random(0, waitingCashiers.size() - 1));
        } else return workingCashiers.get(Helper.random(0, workingCashiers.size() - 1));
    }


    private static void openCashier() {
        int c = selectCashier(true);
        System.out.println("Open " + cashiers[c]);
        cashiers[c].setShouldCloseCashbox(false);
        synchronized (cashiers[c]) {
            cashiers[c].notify();
        }
    }


    private static void closeCashier() {
        int c = selectCashier(false);
        System.out.println("Close " + cashiers[c]);
        cashiers[c].setShouldCloseCashbox(true);
    }


}
