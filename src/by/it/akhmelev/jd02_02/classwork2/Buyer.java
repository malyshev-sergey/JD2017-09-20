package by.it.akhmelev.jd02_02.classwork2;

class Buyer extends Thread implements IBuyer {

    private int number;

    Buyer(int number) {
        super("Buyer № ".concat(Integer.toString(number)));
        this.number = number;
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
        System.out.println(this + " start choose goods");
        int goodsCount = Helper.random(1, 4);
        for (int i = 0; i < goodsCount; i++) {
            int timeout = Helper.random(100, 1000);
            System.out.println(this + " timeout=" + timeout);
            String keyGood = Goods.items.randomGood();
            double price = Goods.items.get(keyGood);
            System.out.printf("%s choose %s, price=%f\n",
                    this, keyGood, price);
            Helper.sleep(timeout);
        }
        System.out.println(this + " stop choose goods");
    }

    @Override
    public void goToQueue() {
        synchronized (Dispatcher.buyerQueue) {
            Dispatcher.buyerQueue.addLast(this);
            System.out.println("ok+"+Dispatcher.buyerQueue.size());
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
        System.out.println(this + " out from market");
    }
}
