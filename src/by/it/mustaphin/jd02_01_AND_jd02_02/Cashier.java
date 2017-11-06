package by.it.mustaphin.jd02_01_AND_jd02_02;

public class Cashier implements Runnable {

    Thread thread;
    Buyer buyer;

    public Cashier(String name) {
        thread = new Thread(this, name);
        thread.start();
    }

    void toHandle(Buyer buyer) {
        if (null != buyer) {
            try {
                Thread.sleep((long) ((Math.random() * 5000) + 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int total = 0;
            System.out.println("buyer.name" + buyer.name);
            for (Goods good : buyer.bucket) {
                System.out.printf("%s %s %-2d\n", Thread.currentThread().getName(), good, good.getPrice());
                total += good.getPrice();
            }
            System.out.printf("ИТОГ: %s %d\n", buyer.name, total);
            synchronized (buyer) {
                buyer.notify();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            toHandle(Market.buyers.poll());
        }
    }
}
