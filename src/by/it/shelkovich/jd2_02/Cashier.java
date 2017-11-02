package by.it.shelkovich.jd2_02;

public class Cashier extends Thread{
    int id;
    Cashier(int id){
        this.id = id;
    }
    private boolean paused = true;

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void run(){
        while(!Thread.interrupted()){
            while (paused){
                System.err.println("Cashier "+id+" is paused");
                synchronized (this){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Buyer buyer;
            if((buyer = BuyerQueue.pensQueue.poll()) == null){
                if((buyer = BuyerQueue.queue.poll()) == null){
                    Util.sleep(100);
                    continue;
                }
            }

            int timeout = Util.getRandomIntFromRange(2000,5000);
            Util.sleep(timeout);

            System.out.printf("Покупатель %d%s был обслужен кассиром %d (%dмс.)\n", buyer.getNum(), (buyer.isPensioneer() ? " (пенсионер)" : ""), id, timeout);
            buyer.setServiced();
            synchronized (buyer) {
                buyer.notify();
            }
        }
        System.err.println("Кассир "+id+" завершает работу");
    }
}
