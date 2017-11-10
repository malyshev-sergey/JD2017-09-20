package by.it.meshchenko.jd02_03;


import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;


public class Buyer extends Thread implements IBuyer, IUseBasket {
    private int number;     //Номер покупателя
    boolean isPensioner;    //true если пенсионер
    private double _P;      //Коэффициент скорости пенсионера

    //Покупатели, которые в магазине
    static final LinkedBlockingQueue<Buyer> listBlockingBuyers = new LinkedBlockingQueue<>();

    final Deque<ChooseGood> basket  = new LinkedList<>();

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
        takeBasket();
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
            putGoodsToBasket(keyGood, price);
        }
        Dispatcher.printWork(printStatus(this + " stop choose goods"));
    }

    @Override
    public void goToQueue() {
        Dispatcher.buyerBlockQueue.add(this);
        Dispatcher.printWork(printStatus(this + " join queue, hi is #"
                + Dispatcher.buyerBlockQueue.size()));
        // Отдаём разрешение 'выбор товара в зале'
        Dispatcher.hallCapacitySemaphore.release();
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
        Dispatcher.countBasketSemaphore.release();
        Dispatcher.printWork(printStatus(this + " returned basket"));
        Dispatcher.printWork(printStatus(this + " out from market"));
        Buyer.listBlockingBuyers.remove(this);
    }

    @Override
    public void takeBasket() {
        try {
            // Берём разерешние чтобы взять корзину
            Dispatcher.countBasketSemaphore.acquire();
            Dispatcher.printWork(printStatus(this + " take basket"));
            int timeout = Helper.random((int) (100 * _P), (int) (200 * _P));  //Взять корзину 0,1..0,2 сек
            Dispatcher.printWork(printStatus(this + " timeout take basket: " + timeout));
            Helper.sleep(timeout);
            // Берём разрешение 'выбор товара в зале'
            Dispatcher.hallCapacitySemaphore.acquire();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToBasket(String keyGood, double price) {
        Dispatcher.printWork(printStatus(this + " put "+ keyGood +" to basket"));
        basket.addLast(new ChooseGood(keyGood, price));
        int timeout = Helper.random((int)(100*_P), (int)(200*_P));  //Положить товар в корзину 0,1..0,2 сек
        Dispatcher.printWork(printStatus(this + " timeout put " + keyGood +" to basket: " + timeout));
        Helper.sleep(timeout);
    }

    private PrintView printStatus(String str){
        PrintView pv = new PrintView();
        pv.setBuyerState(str);
        return pv;
    }
}
