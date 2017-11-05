package by.it.mustaphin.jd02_01;

public class Buyer implements Runnable, IBuyer, IUseBucket {

    Thread thread;

    Buyer(String name) {
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBucket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(Thread.currentThread().getName() + " вошёл в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(Thread.currentThread().getName() + " начал выбирать товар");
        try {
            thread.sleep((long) (1000 * ((Math.random() * 2) + 0.5)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " закончил выбирать товар");
    }

    @Override
    public void goToOut() {
        System.out.println(Thread.currentThread().getName() + " покинул магазин");
    }

    @Override
    public void takeBucket() {
        try {
            thread.sleep((long) (1000 * ((Math.random() * 1.2) + 0.1)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " взял корзину");
    }

    @Override
    public void putGoodsToBucket() {
        try {
            thread.sleep((long) (1000 * ((Math.random() * 1.2) + 0.1)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " положил товар в корзину");
    }
}
