package by.it.akhmelev.jd02_01.classwork;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        int counterBuyers = 0;

        List<Buyer> buyers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int currentBuyerCount = Helper.random(0, 2);
            for (int j = 0; j < currentBuyerCount; j++) {
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
