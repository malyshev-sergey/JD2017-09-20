package by.it.govor.jd02_03;


import java.util.HashMap;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private int  number;
       private double speed=1;
    Buyer(int number,boolean b){
         this.number=number;
        if(b) {speed=1.5;
            System.out.println(number+": Пенсионер");}
     }
    @Override
    public String toString() {
        return getName();
    }

    public  void run() {
        enterToMarket();
        takeBacket();
        productSelection();
        putGoodToBacket();
        goToQueue();
        out();
    }

    @Override
    public void enterToMarket() {
        System.out.println(number+": зашел");
    }


    @Override
    public void takeBacket() {
        System.out.println(number+": взял корзину");
        Sleep.sleep(0,200,speed);
    }
    @Override
    public void productSelection() {
        System.out.println(number+": выберает продукцию");
        Sleep.sleep(500,2000,speed);

    }



    @Override
    public void putGoodToBacket() {
        double sum=0;
        GootProduct good = new GootProduct();
        good.product();
        Sleep.sleep(0,300,speed);
        HashMap<String,Double> produck = new HashMap<>(good.gootproducts(NewRandom.random(1,4)));
        System.out.println(number+": положил в корзину: \n"+ produck);
        for (Double value : produck.values()) {
          sum+=value;
        }
        System.out.println(number+": купил продуктов на сумму:"+sum+" руб");

    }

    @Override
    public void goToQueue() {
        synchronized (Dispatcher.buyerQueue) {
            Dispatcher.buyerQueue.addLast(this);
            System.out.println("ok+"+ Dispatcher.buyerQueue.size());
        }
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void out() {
        System.out.println(number+": вышел");
    }





}
