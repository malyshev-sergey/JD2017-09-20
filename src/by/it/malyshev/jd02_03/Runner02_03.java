package by.it.malyshev.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Runner02_03 {

    public static void main(String[] args) {
        int counterBuyers = 0;

        Dispatcher d = new Dispatcher();
        new Thread(d).start();

        List<Integer> stat = new ArrayList<>();
        List<Integer> stat2 = new ArrayList<>();

        int timeCounter = 0;
        while (counterBuyers < Dispatcher.planBuyer) {

            if ((timeCounter % 60 <= 30 && Buyer.buyersIn.size() <= (timeCounter % 60 + 10))
                    || (timeCounter % 60 > 30 && Buyer.buyersIn.size() <= 70 - timeCounter % 60)) {

                int currentBuyerCount = Helper.random(0, 4);
                for (int j = 0; j < currentBuyerCount; j++) {
                    if (counterBuyers < Dispatcher.planBuyer) {

                        Buyer b = (Helper.random(1, 4) == 4) ? new Buyer(++counterBuyers, true) : new Buyer(++counterBuyers, false);
                        b.start();
                    }
                }
            }

            stat.add(Buyer.buyers.size());
            stat2.add(Buyer.buyersIn.size());

            timeCounter++;
            Helper.sleep(1000);
        }

        for (Buyer buyer : Buyer.buyers)
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("\nEnd of service!");

        System.out.println("\n\nStatistics");
        for (int i = 0; i < stat.size(); i++) {
            System.out.printf("%d sec %d buyers (%d in the market)\n", (i + 1), stat.get(i), stat2.get(i));
        }

    }
}