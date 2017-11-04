package by.it.ali.jd02_02;




public class Buyer extends Thread implements IBuyer, IUseBacket{

    Goods it = new Goods();
    private int number;
    public Buyer(int number){
        super("Buyer № ".concat(Integer.toString(number)));
        this.number = number;
    }

//    public static void create(int count, int name){
//        for (int i = 0; i <=count ; i++) {
//            new Buyer(name,i);
//            start();
//        }
//    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.getName()+" вошёл в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this.getName()+" выбирает товары");
        int timeout = Tools.random(500,2000);
        Tools.sleep(timeout);
        }

    @Override
    public void goToOut() {
        System.out.println(this.getName()+" покинул магазин");
    }

    @Override
    public void takeBacket() {
        System.out.println(this.getName()+" взял корзину");
        int timeout = Tools.random(100,200);
        Tools.sleep(timeout);
    }

    @Override
    public void putGoodsToBacket() {
        int goods = Tools.random(1,4);
        for (int i = 0; i < goods ; i++) {
            String j = it.names();
            Double price = it.get(j);
            System.out.println(this.getName()+" поместил в корзину "+j+" за "+price+" руб.");
        }

    }
}
