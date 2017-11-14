package by.it.govor.jd02_02;


public class Cashier implements Runnable {
    int numberCas;
    Cashier ( int numberCas){
       this.numberCas =numberCas;
    }
    @Override
    public void run() {
        while(Dispatcher.nowBuyer<Dispatcher.maxBuyer){
            Buyer b;
            synchronized (Dispatcher.buyerQueue) {
                b = Dispatcher.buyerQueue.pollFirst();
            }
            if (b != null) {
                System.out.println(this + " подешел к кассе " + b);
                by.it.govor.jd02_01.Sleep.sleep(10,20);
                System.out.println(this + " ушел с кассы " + b);
                synchronized (b) {
                    b.notify();
                }

                synchronized (Dispatcher.maxBuyer) {
                    Dispatcher.nowBuyer++;
                }
            }
        }
    }
    public String toString() {
        return "Cashier №"+numberCas;
    }
}
