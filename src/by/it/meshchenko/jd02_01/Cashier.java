package by.it.meshchenko.jd02_01;

public class Cashier implements Runnable {
    private int num;

    public Cashier(int num) {
        this.num = num;
    }

    @Override
    public void run() {
//        while (Dispatcher.countBuyer < Dispatcher.planBuyer) {
//            Buyer b;
//            synchronized (Dispatcher.buyerQueue) {
//                b = Dispatcher.buyerQueue.pollFirst();
//            }
//            if (b != null) {
//                System.out.println(this + " start service for " + b);
//                Helper.sleep(Helper.random(2000, 5000));
//                System.out.println(this + " stop service for " + b);
//                synchronized (b) {
//                    b.notify();
//                }
//
//                synchronized (Dispatcher.planBuyer) {
//                    Dispatcher.countBuyer++;
//                }
//            }
//
//        }
    }

    @Override
    public String toString() {
        return "Cashier №" + num;
    }
}
