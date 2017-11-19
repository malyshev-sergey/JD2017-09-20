package by.it.shishov.jd02_01;

/**
 * Created by Сергей on 27.10.2017.
 */
public class Buyer extends Thread  implements IBuyer{
    private int number;

    Buyer(String name, int number) {
        super("Buyer №".concat((Integer.toString(number))));
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
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enters to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " starts choose goods");
        int goodsCount = Helper.random(1,4);
        for (int i = 0; i < goodsCount; i++) {
            int timeout  = Helper.random(100,200);
            System.out.println(this + " timeout = " + timeout);
            String keyGood = Goods.items.randomGood();
            double price = Goods.items.get(keyGood);
            System.out.printf("%s choose %s, price = %f \n", this,keyGood,price);
        }
        System.out.println(this + " stops choose goods");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " exits the market");
    }
}
