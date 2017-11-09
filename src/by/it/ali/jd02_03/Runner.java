package by.it.ali.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {


    public static void main(String[] args) {
        int buyerCount = 0;
        int cashierCount=0;
        ExecutorService executor= Executors.newFixedThreadPool(5);
        executor.execute(new Cashier(++cashierCount));
        executor.execute(new Cashier(++cashierCount));
        while (buyerCount< Counter.planBuyer) {
            int a = Tools.random(0,3);
            for (int j = 0; j <a; j++)
                if (buyerCount < Counter.planBuyer){
                Buyer b = new Buyer(++buyerCount);
                b.start();
            }
        }
        executor.shutdown();
    }
}
