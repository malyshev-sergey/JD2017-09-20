package by.it.shelkovich.jd2_03;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

public class Basket {
    static ArrayBlockingQueue<HashMap<Product, Integer>> baskets= new ArrayBlockingQueue<>(30);
    static {
        for (int i = 0; i < 30; i++) {
            try {
                baskets.put(new HashMap<Product, Integer>());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
