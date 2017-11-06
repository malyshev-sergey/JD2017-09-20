package by.it.ali.jd02_02;

public class Runner {


    public static void main(String[] args) {
        int buyerCount = 0;
        //int cashierCount=0;
        for (int i = 1; i <= 5; i++) {
            Cashier c = new Cashier(i);
            c.start();
        }
        //long time = System.currentTimeMillis();
        //for (int i = 0; i < 10; i++)
        while (buyerCount< Counter.planBuyer) {
//            if (buyerCount%5==0){
//                Cashier c = new Cashier(++cashierCount);
//                c.start();
//            }
            int a = Tools.random(0,3);
            for (int j = 0; j <a; j++)
                if (buyerCount < Counter.planBuyer){
                Buyer b = new Buyer(++buyerCount);
                b.start();
            }
        }
    }
}
