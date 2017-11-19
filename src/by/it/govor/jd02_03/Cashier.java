package by.it.govor.jd02_03;


public class Cashier implements Runnable {
    int numberCas;
    Cashier ( int numberCas){
       this.numberCas =numberCas;
    }
    @Override
    public void run() {
        while(Dispatcher.maxBuyer.get() <= Dispatcher.nowBuyer.get()){

            Buyer b;

                b = Dispatcher.buyerQueue.pollFirst();

            if (b != null) {
                System.out.println(this + " подешел к кассе " + b);
                by.it.govor.jd02_01.Sleep.sleep(10,20);
                System.out.println(this + " ушел с кассы " + b);
                synchronized (b) {
                    b.notify();
                }


                    Dispatcher.nowBuyer.addAndGet(1);
            }
        }
    }
    public String toString() {
        return "Cashier №"+numberCas;
    }
}
