package by.it.meshchenko.jd02_01;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private int number;
    boolean isPensioner;
    private double _P;
    private final Deque<ChooseCood> backet  = new LinkedList<>();

    Buyer(int number, boolean isPensioner) {
        super("Buyer № " + Integer.toString(number) + (isPensioner ? " P" : ""));
        this.number = number;
        this.isPensioner = isPensioner;
        this._P = isPensioner ? 1.5 : 1;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start choose goods");   //***********************
        int goodsCount = Helper.random(1, 4);
        for (int i = 0; i < goodsCount; i++) {
            int timeout = Helper.random((int)(100*_P), (int)(400*_P));
            System.out.println(this + " timeout: choose Goods = " + timeout); //***********************
            String keyGood = Goods.items.randomGood();
            double price = Goods.items.get(keyGood);
            System.out.printf("%s choose %s, price=%-3.1f\n", this, keyGood, price);   //***********************
            Helper.sleep(timeout);
            putGoodsToBacket(keyGood, price);
        }
        System.out.println(this + " stop choose goods");   //***********************
    }

    @Override
    public void goToQueue() {
//        synchronized (Dispatcher.buyerQueue) {
//            Dispatcher.buyerQueue.addLast(this);
//            System.out.println(this + " join queue, hi is #" + Dispatcher.buyerQueue.size());
//        }
//        synchronized (this) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Override
    public void goToOut() {

        System.out.println(this + " out from market");   //***********************
    }

    @Override
    public void takeBacket() {
        System.out.println(this + " take backet");   //***********************
        int timeout = Helper.random((int)(100*_P), (int)(200*_P));
        System.out.println(this + " timeout: take backet = " + timeout);   //***********************
        Helper.sleep(timeout);
    }

    @Override
    public void putGoodsToBacket(String keyGood, double price) {
        System.out.println(this + "put "+ keyGood +" to backet");   //***********************
        backet.addLast(new ChooseCood(keyGood, price));
        int timeout = Helper.random((int)(100*_P), (int)(200*_P));
        System.out.println(this + " timeout: put " + keyGood +" = " + timeout);   //***********************
        Helper.sleep(timeout);
    }
}
