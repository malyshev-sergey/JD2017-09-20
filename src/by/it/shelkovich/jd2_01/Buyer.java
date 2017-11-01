package by.it.shelkovich.jd2_01;

import java.util.HashMap;

public class Buyer extends Thread implements IBuyer, IAbleToUseBasket {
    private boolean pensioneer;
    private int num;
    private final double pensioneerRatio = 1.5;

    private HashMap<Product, Integer> basket = new HashMap<>();

    Buyer(int num){
        this(num, false);
    }

    Buyer(int num, boolean pensioneer){
        this.num = num;
        this.pensioneer = pensioneer;
    }

    public void run(){
        enterToMarket();
        takeBasket();
        putGoodsToBasket();
        exitFromMarket();
    }

    @Override
    public void takeBasket() {
        int timeout = Util.getRandomIntFromRange(100,200);
        if (pensioneer) timeout *= pensioneerRatio;
        Util.sleep(timeout);
        System.out.printf("Покупатель %d%s берёт корзину (%dмс.)\n", num, (pensioneer ? " (пенсионер)": ""), timeout);

    }

    @Override
    public void putGoodsToBasket() {
        int productCount = (int)Math.round(Math.random()*3)+1;
        System.out.printf("Покупатель %d%s решил купить %d товаров\n", num, (pensioneer ? " (пенсионер)": ""), productCount);
        for (int i = 0; i < productCount; i++) {
            Product product = chooseGoods();
            int timeout = Util.getRandomIntFromRange(100,200);
            basket.put(product, (int)Math.round(Math.random()*4)+1);
            if (pensioneer) timeout *= pensioneerRatio;
            Util.sleep(timeout);
            System.out.printf("Покупатель %d%s кладёт товар %s в корзину (%dмс.)\n", num, (pensioneer ? " (пенсионер)": ""), product, timeout);
        }

    }

    @Override
    public void enterToMarket() {
        System.out.printf("Покупатель %d%s вошёл в магазин\n", num, (pensioneer ? " (пенсионер)": ""));
    }

    @Override
    public Product chooseGoods() {
        System.out.printf("Покупатель %d%s приступил к выбору товаров\n", num, (pensioneer ? " (пенсионер)": ""));
        int timeout = Util.getRandomIntFromRange(500,2000);
        if (pensioneer) timeout *= pensioneerRatio;
        Util.sleep(timeout);
        Product product = Price.products.get((int)Math.round(Math.random()*(Price.products.size()-1)));
        System.out.printf("Покупатель %d%s выбрал товар %s (%dмc.)\n", num, (pensioneer ? " (пенсионер)": ""), product, timeout);
        return product;
    }

    @Override
    public void exitFromMarket() {
        System.out.printf("Покупатель %d%s вышел из магазина\n", num, (pensioneer ? " (пенсионер)": ""));
    }
}
