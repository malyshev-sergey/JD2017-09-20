package by.it.ali.jd02_02;


public class Cashier extends Thread {

    private final int number;

    public Cashier(int number){
        super("Cashier № ".concat(Integer.toString(number)));
        this.number = number;
    }

    @Override
    public void run() {
        while (Counter.countBuyer < Counter.planBuyer) {
            Buyer b;
            synchronized (Counter.buyerQueue) {
                b = Counter.buyerQueue.pollFirst();
            }
            if (b != null) {
                System.out.println(this.getName() + " start service for " + b);
                Tools.sleep(Tools.random(2000, 5000));
                System.out.println(this.getName() + " stop service for " + b);
                synchronized (b) {
                    b.notify();
                }
                synchronized (Counter.planBuyer) {
                    Counter.countBuyer++;
                }
            }

        }
    }
    @Override
    public String toString() {
        return "Cashier №" + number;
    }
}
