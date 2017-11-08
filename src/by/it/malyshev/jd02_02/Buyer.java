package by.it.malyshev.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket;
    private String chosenGoods;

    boolean isPensioner() {
        return pensioner;
    }

    private boolean pensioner;
    private final double pensionerRetardation = 1.5;

    static final List<Buyer> buyers = new ArrayList<>();
    static final List<Buyer> buyersIn = new ArrayList<>();


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
        takeBasket();
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
        synchronized (this) {
            buyersIn.remove(this);
        }
        System.out.println(this + " went out from market");
    }


    @Override
    public void takeBasket() {
        while (Basket.baskets.size() == 0) {
            Helper.sleep(500);
        }
        synchronized (Basket.baskets) {
            if (Basket.baskets.size() != 0) {
                int selectBasket = Helper.random(0, Basket.baskets.size() - 1);
                basket = Basket.baskets.get(selectBasket);
                Basket.baskets.remove(selectBasket);
            }
        }
        if (basket==null) {
             takeBasket();
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
//        System.out.println(basket);
        basket.add(chosenGoods);
        Helper.sleep(timeout);
        System.out.println(this + " put " + chosenGoods + " in the basket (" + timeout + " ms)");
    }

    @Override
    public void goToQueue() {
        synchronized (Dispatcher.buyerQueue) {
            Dispatcher.buyerQueue.add(this);
            System.out.println("ok+" + Dispatcher.buyerQueue.size());
        }
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

