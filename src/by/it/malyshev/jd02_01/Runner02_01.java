package by.it.malyshev.jd02_01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Runner02_01 {

    static CopyOnWriteArrayList<Buyer> buyersIn = new CopyOnWriteArrayList<>();
//    static int time;
    static AtomicInteger out=new AtomicInteger(0);

    public static void main(String[] args) {
        int counterBuyers = 0;

        List<Buyer> buyers = new ArrayList<>();
        List<Integer> stat = new ArrayList<>();
        List<Integer> stat2 = new ArrayList<>();
        List<Integer> stat3 = new ArrayList<>();

        for (int i = 0; i < 120; i++) {
//            int buyersInShop = 0;
//            for (Buyer buyer : buyers) {
//                if (buyer.isAlive()) buyersInShop++;
//            }
//            stat.add(buyersInShop);
            stat.add(buyersIn.size());
            stat2.add(buyers.size());
            stat3.add(out.intValue());

            if ((i % 60 <= 30 && buyersIn.size() <= (i % 60 + 10))
                   ||  (i % 60 > 30 && buyersIn.size() <= 70 - i % 60)) {

                int currentBuyerCount = Helper.random(0, 2);
                for (int j = 0; j < currentBuyerCount; j++) {
                    Buyer b = (Helper.random(1, 4) == 4) ? new Buyer(++counterBuyers, true) : new Buyer(++counterBuyers, false);
                    b.start();
                    buyers.add(b);
                    buyersIn.add(b);
                }
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

        System.out.println("\n\nСтатистика посещения магазина по секундам:");
        for (int i = 0; i < stat.size(); i++) {
            System.out.printf("%d: %d %d покупателей %d\n", i, stat.get(i),stat2.get(i), stat3.get(i));
        }


    }
}