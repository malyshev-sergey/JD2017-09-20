package by.it.shelkovich.jd2_02;

import java.util.ArrayList;
import java.util.List;

public class Runner2_2 {
    private static int buyerNum = 0;
    private static List<Buyer> buyers = new ArrayList<>();
    private static List<Integer> stat = new ArrayList<>();
    private static final int limit = 40;
    private static int buyersAlive = 0;
    private static int buyersAtCass = 0;

    public static void main(String[] args) {

        CashierDispatcher cashierDispatcher = new CashierDispatcher();
        cashierDispatcher.setDaemon(true);
        cashierDispatcher.start();

        for (int i = 1; i < 120; i++) {
            buyersAlive = 0;
            buyersAtCass = 0;

            for (Buyer buyer : buyers) {
                if (buyer.isAlive()) buyersAlive++;
                if (buyer.getState() == Thread.State.WAITING) buyersAtCass++;
            }
            stat.add(buyersAlive);

            int preferCount;
            int quarter = i / 30 + 1;

            if (quarter % 2 != 0) {
                preferCount = (i % 30) + 10;
                inviteBuyers(Util.getRandomIntFromRange(0, preferCount - buyersAlive));
                System.err.println("Sec " + i + "> Alive " + buyersAlive + " At cass " + buyersAtCass);
            } else {
                System.err.println("Sec " + i + "< Alive " + buyersAlive + " At cass " + buyersAtCass);
                preferCount = (30 - i % 30) + 10;
                if (buyersAlive < preferCount) inviteBuyers(Util.getRandomIntFromRange(0,2));
            }

            Util.sleep(1000);
        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n\nСтатистика посещения магазина по секундам:");
        for (int i = 0; i < stat.size(); i++) {
            System.out.printf("%d: %d покупателей\n", i, stat.get(i));
        }


    }

    private static void inviteBuyers(int count) {
        for (int i = 0; i < count; i++) {
            if (buyersAlive < limit) {
                int pens = (int) Math.round(Math.random() * 3);
                boolean pensioner = false;
                if (pens == 0) pensioner = true;
                Buyer buyer = new Buyer(++buyerNum, pensioner);
                buyer.start();
                buyers.add(buyer);
            }
        }
    }
}
