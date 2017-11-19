package by.it.govor.jd02_01;


public class Buyer extends Thread implements IBuyer, IUseBacket {
    private int  number;
       private double speed=1;
    Buyer(int number,boolean b){
         this.number=number;
        if(b) {speed=1.5;
            System.out.println(number+": Пенсионер");}
     }

    public  void run() {
        enterToMarket();
        takeBacket();
        productSelection();
        putGoodToBacket();
        out();
    }

    @Override
    public void enterToMarket() {
        System.out.println(number+": зашел");
    }


    @Override
    public void takeBacket() {
        System.out.println(number+": взял корзину");
        Sleep.sleep(0,200,speed);
    }
    @Override
    public void productSelection() {
        System.out.println(number+": выберает продукцию");
        Sleep.sleep(500,2000,speed);

    }
    @Override
    public void putGoodToBacket() {
        GootProduct good = new GootProduct();
        good.product();
        Sleep.sleep(0,300,speed);
        System.out.println(number+": положил в корзину: \n"+ good.gootproducts(NewRandom.random(1,4)));

    }


    @Override
    public void out() {
        System.out.println(number+": вышел");
    }





}
