package by.it.shishov.jd02_01;

/**
 * Created by Сергей on 27.10.2017.
 */
public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Buyer b = new Buyer("Buyer", i);
            b.start();
        }
    }
}
