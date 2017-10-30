package by.it.akhmelev.jd02_02.classwork2;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        int counterBuyers = 0;

        for (int i = 1; i <= 5; i++) {
            Cashier c = new Cashier(i);
            new Thread(c).start();
        }

        List<Buyer> buyers = new ArrayList<>();

        while (counterBuyers < Dispatcher.planBuyer) {
            int currentBuyerCount = Helper.random(0, 2);
            for (int j = 0; j < currentBuyerCount; j++)
                if (counterBuyers < Dispatcher.planBuyer) {
                    Buyer b = new Buyer(++counterBuyers);
                    b.start();
                    buyers.add(b);
                }
            Helper.sleep(1000);
        }
        for (Buyer buyer : buyers)
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Обслуживание завершено!");

    }
}
