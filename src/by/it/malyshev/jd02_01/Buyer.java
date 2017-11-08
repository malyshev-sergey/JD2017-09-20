package by.it.malyshev.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private int number;
    private Basket basket;
    private String chosenGoods;
    private boolean pensioner;
    private final double pensionerRetardation = 1.5;


    Buyer(int number, boolean pensioner) {
        super("Buyer № ".concat(Integer.toString(number)).concat(pensioner?" (pensioner)":""));
        this.number = number;
        this.pensioner=pensioner;
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
            if (pensioner) timeout*=pensionerRetardation;
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
        Runner02_01.buyersIn.remove(this);
        Runner02_01.out.getAndAdd(1);
        System.out.println(this + " out from market");
    }


    @Override
    public void takeBasket() {
        int timeout = Helper.random(100, 200);
        if (pensioner) timeout*=pensionerRetardation;
        Helper.sleep(timeout);
        basket = new Basket();
        System.out.println(this + " took the basket (" + timeout + " ms)");
    }


    @Override
    public void putGoodsToBasket() {
        int timeout = Helper.random(100, 200);
        if (pensioner) timeout*=pensionerRetardation;
        basket.add(chosenGoods);
        Helper.sleep(timeout);
        System.out.println(this + " put " + chosenGoods + " in the basket (" + timeout + " ms)");
    }


}

