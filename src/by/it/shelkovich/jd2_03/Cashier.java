package by.it.shelkovich.jd2_03;

import java.util.HashMap;
import java.util.Map;

public class Cashier implements Runnable {
    static String printMonitor = "";

    int id;

    Cashier(int id) {
        this.id = id;
    }

    private boolean paused = true;

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void run() {
        while (!Thread.interrupted()) {
            while (paused) {
                System.err.println("Cashier " + id + " is paused");
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            if(CashierDispatcher.buyersServiced.get() > 100) break;

            Buyer buyer;
            if ((buyer = BuyerQueue.pollPens()) == null) {
                if ((buyer = BuyerQueue.poll()) == null) {
                    Util.sleep(100);
                    continue;
                }
            }


            int timeout = Util.getRandomIntFromRange(2000, 5000);
            Util.sleep(timeout);

            //
            printCheck(buyer);

            buyer.setServiced();
            synchronized (buyer) {
                buyer.notify();
            }
        }
        System.err.println("Кассир " + id + " завершает работу");
    }

    void printCheck(Buyer buyer) {
        HashMap<Product, Integer> basket = buyer.getBasket();
        int total = 0;
        synchronized (printMonitor) {
            printToCol("Покупатель " + buyer.getNum(), id - 1);
            for (Map.Entry<Product, Integer> line : basket.entrySet()) {
                printToCol(line.getKey() + " * " + line.getValue() + "шт.", id - 1);
                printToCol("="+line.getKey().getPrice() * line.getValue() + "р.", id - 1);
                total += line.getKey().getPrice() * line.getValue();
            }

            BuyerQueue.moneyTotal.addAndGet(total);
            printToCol("Всего: " + total + "р.", id - 1);
            System.out.printf("| %21s | %21s | %21s | %21s | %21s | %2s | %4s |\n", "", "", "", "", "", BuyerQueue.getSize(), BuyerQueue.moneyTotal);
        }
    }

    void printToCol(String str, int col) {
        String[] cols = new String[7];
        for (int i = 0; i < 7; i++) cols[i] = "";
        cols[col] = str;
        System.out.printf("| %21s | %21s | %21s | %21s | %21s | %2s | %4s |\n", cols[0], cols[1], cols[2], cols[3], cols[4], cols[5], cols[6]);
    }

}
