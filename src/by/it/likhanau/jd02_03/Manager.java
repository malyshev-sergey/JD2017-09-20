package by.it.likhanau.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Manager implements Runnable {

    @Override
    public void run() {
        int buyerCount = 0;
        int cashierCount = 0;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new Cashier(++cashierCount));
        executor.execute(new Cashier(++cashierCount));

        while (buyerCount < Dispatcher.planBuyer) {
            int a = Util.generateRandomNumber(0, 3);
            for (int j = 0; j < a; j++)
                if (buyerCount < Dispatcher.planBuyer) {
                    boolean pensioner = false;
                    int num = (int) (Math.random() * 10);
                    if (num == 0 || num == 1 || num == 2) {
                        pensioner = true;
                    }
                    Thread thread = new Thread(new Buyer(++buyerCount, pensioner));
                    thread.start();
                }
        }
        executor.shutdown();

    }
}
