package by.it.ali.jd02_02;

public class Runner {


    public static void main(String[] args) {
        int buyerCount = 0;
        //long time = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int a = Tools.random(0,2);
            for (int j = 0; j <=a; j++) {
                Buyer b = new Buyer(++buyerCount);
                b.start();
            }
        }
    }
}
