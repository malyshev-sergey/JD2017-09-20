package by.it.likhanau.jd02_03;


public class Cashier implements Runnable {

    private final int cashierId;

    public Cashier(int cashierId) {
        this.cashierId = cashierId;
    }

    @Override
    public void run() {
        while (Dispatcher.countBuyer < Dispatcher.planBuyer) {
            Buyer b;
            synchronized (Dispatcher.buyerQueue) {
                b = Dispatcher.buyerQueue.pollFirst();
            }
            if (b != null) {
                System.out.println(this + " start service for " + b);
                Util.makeThreadSleep(Util.generateRandomNumber(2000, 5000));
                System.out.println(this + " stop service for " + b);
                synchronized (b) {
                    b.notify();
                }
                synchronized (Dispatcher.planBuyer) {
                    Dispatcher.countBuyer++;
                }
            }

        }
    }

    @Override
    public String toString() {
        return "Cashier #" + cashierId + ".";
    }
}
