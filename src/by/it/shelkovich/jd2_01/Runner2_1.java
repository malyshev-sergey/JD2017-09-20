package by.it.shelkovich.jd2_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Runner2_1 {
    private static int buyerNum = 0;
    private static List<Buyer> buyers = new ArrayList<>();
    private static List<Integer> stat = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 1; i < 120; i++) {
            int buyersInShop = 0;
            for (Buyer buyer : buyers) {
                if (buyer.isAlive()) buyersInShop++;
            }
            stat.add(buyersInShop);

            int limit;
            int quarter = i / 30 + 1;

            //Экспериментально подобранные значения, чтобы примерно вписываться в граффик задания (около 10 посетителей в начале и конце минуты, около 40 в середине минуты)
            if (quarter % 2 != 0) {
                limit = (i % 30)/3;
            } else {
                limit = (30 - i % 30)/3;
            }

            int count = (int) Math.round(Math.random() * 5 + limit);
            /* limit изменяется от 0 до 10, рандом даёт в среднем 2.5, количество новых посетителей (count), значит, изменятеся от 2.5 до 12.5
            * 2.5 посетителей в секунду уравновешивается где-то на значении чуть меньше десяти посетителей одновременно в магазине.
            * 12.5 - где-то в районе 40 посетителей одновременно.
            * такие дела.*/
            inviteBuyers(count);

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
            int pens = (int) Math.round(Math.random() * 3);
            boolean pensioner = false;
            if (pens == 0) pensioner = true;
            Buyer buyer = new Buyer(++buyerNum, pensioner);
            buyer.start();
            buyers.add(buyer);
        }
    }
}
