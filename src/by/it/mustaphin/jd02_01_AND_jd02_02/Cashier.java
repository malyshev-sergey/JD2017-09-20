package by.it.mustaphin.jd02_01_AND_jd02_02;

public class Cashier implements Runnable {

    Thread thread;

    public Cashier(String name) {
        thread = new Thread(this, name);
        thread.start();
    }

    void toHandle(Buyer buyer) {
        try {
            Thread.sleep((long) ((Math.random() * 5000) + 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int total = 0;
        for (Goods good : buyer.bucket) {
            System.out.printf("%s %-2d", good, good.getPrice());
            total += good.getPrice();
        }
        System.out.printf("ИТОГ: %d", total);
    }

    @Override
    public void run() {

    }
}
