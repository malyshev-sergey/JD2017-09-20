package by.it.malyshev.jd02_03;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket;
    private String chosenGoods;

    boolean isPensioner() {
        return pensioner;
    }

    private boolean pensioner;
    final double pensionerRetardation = 1.5;

    static CopyOnWriteArrayList<Buyer> buyers = new CopyOnWriteArrayList<>();
    static CopyOnWriteArrayList<Buyer> buyersIn = new CopyOnWriteArrayList<>();

    final Lock buyerLock = new ReentrantLock();
    final Condition notRunBuyer = buyerLock.newCondition();

    private static Semaphore hallCapasity = new Semaphore(20);

    Buyer(int number, boolean pensioner) {
        super("Buyer №".concat(Integer.toString(number)).concat(pensioner ? " (pensioner)" : ""));
        this.pensioner = pensioner;
        buyers.add(this);
        buyersIn.add(this);
    }

    Basket getBasket() {
        return basket;
    }

    @Override
    public String toString() {
        return getName();
    }


    @Override
    public void run() {
        enterToMarket();
        try {
            hallCapasity.acquire();
            takeBasket();
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            hallCapasity.release();
        }
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }


    @Override
    public void chooseGoods() {
        System.out.println(this + " start choose goods");
        int goodsCount = Helper.random(1, Basket.basketCapacity);
        for (int i = 0; i < goodsCount; i++) {
            int timeout = Helper.random(500, 2000);
            if (pensioner) timeout *= pensionerRetardation;
            System.out.println(this + " timeout=" + timeout);
            chosenGoods = Goods.items.randomGood();
            double price = Goods.items.get(chosenGoods);
            System.out.printf("%s choose %s, price=%f\n",
                    this, chosenGoods, price);
            Helper.sleep(timeout);
            putGoodsToBasket();
        }
        System.out.println(this + " stop choose goods");
    }


    @Override
    public void goToOut() {
        buyersIn.remove(this);
        System.out.println(this + " went out from market");
    }


    @Override
    public void takeBasket() {
        try {
            basket = Basket.baskets.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int timeout = Helper.random(100, 200);
        if (pensioner) timeout *= pensionerRetardation;
        Helper.sleep(timeout);
        System.out.println(this + " took the basket (" + timeout + " ms)");
    }


    @Override
    public void putGoodsToBasket() {
        int timeout = Helper.random(100, 200);
        if (pensioner) timeout *= pensionerRetardation;
        basket.add(chosenGoods);
        Helper.sleep(timeout);
        System.out.println(this + " put " + chosenGoods + " in the basket (" + timeout + " ms)");
    }

    @Override
    public void goToQueue() {
        Dispatcher.buyerQueue.add(this);
        System.out.println("ok+" + Dispatcher.buyerQueue.size());

        this.buyerLock.lock();
            try {
                this.notRunBuyer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.buyerLock.unlock();
            }
    }

}

