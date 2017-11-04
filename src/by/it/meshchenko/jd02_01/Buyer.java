package by.it.meshchenko.jd02_01;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    //Номер покупателя
    private int number;
    //true если пенсионер
    boolean isPensioner;
    //Коэффициент скорости пенсионера
    private double _P;

    static final Lock lockBuyers = new ReentrantLock();
    //Покупатели, которые в магазине
    static final List<Buyer> listBuyers = new ArrayList<>();

    final Deque<ChooseGood> backet  = new LinkedList<>();
    private interface IgoToQueueBuyers{
        Deque<Buyer> queue(boolean p);
    }

    Buyer(int number, boolean isPensioner) {
        super("B_#" + Integer.toString(number) + (isPensioner ? "P" : ""));
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
        Dispatcher.printWork(printStatus(this + " enter to market"));
    }

    @Override
    public void chooseGoods() {
        Dispatcher.printWork(printStatus(this + " start choose goods"));
        int goodsCount = Helper.random(1, 4);
        for (int i = 0; i < goodsCount; i++) {
            int timeout = Helper.random((int)(500*_P), (int)(2000*_P)); // Время выбора товара 0,5..2 сек
            String keyGood = Goods.items.randomGood();
            double price = Goods.items.get(keyGood);
            Dispatcher.printWork(printStatus(this + " timeout choose Goods: " + timeout
                    + String.format("; choose %s, price=%-3.1f", keyGood, price)));
            Helper.sleep(timeout);
            putGoodsToBacket(keyGood, price);
        }
        Dispatcher.printWork(printStatus(this + " stop choose goods"));
    }

    @Override
    public void goToQueue() {
        synchronized (Dispatcher.buyerQueue) {
            Dispatcher.buyerQueue.add(this);
            Dispatcher.printWork(printStatus(this + " join queue, hi is #" + Dispatcher.buyerQueue.size()));
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
    public void goToOut() {
        Dispatcher.printWork(printStatus(this + " out from market"));
        try{
            Buyer.lockBuyers.lock();
            Buyer.listBuyers.remove(this);
        }
        finally {
            Buyer.lockBuyers.unlock();
        }
    }

    @Override
    public void takeBacket() {
        Dispatcher.printWork(printStatus(this + " take backet"));
        int timeout = Helper.random((int)(100*_P), (int)(200*_P));  //Взять корзину 0,1..0,2 сек
        Dispatcher.printWork(printStatus(this + " timeout take backet: " + timeout));
        Helper.sleep(timeout);
    }

    @Override
    public void putGoodsToBacket(String keyGood, double price) {
        Dispatcher.printWork(printStatus(this + " put "+ keyGood +" to backet"));
        backet.addLast(new ChooseGood(keyGood, price));
        int timeout = Helper.random((int)(100*_P), (int)(200*_P));  //Положить товар в корзину 0,1..0,2 сек
        Dispatcher.printWork(printStatus(this + " timeout put " + keyGood +" to backet: " + timeout));
        Helper.sleep(timeout);
    }

    private PrintView printStatus(String str){
        PrintView pv = new PrintView();
        pv.setBuyerState(str);
        return pv;
    }
}
