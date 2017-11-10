package by.it.ali.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 class Goods extends HashMap<String, Double> {
    private static List<String> items;

     Goods() {
        this.put("Яйца", 1.4);
        this.put("Молоко", 1.7);
        this.put("Хлеб", 0.4);
        this.put("Сахар", 0.9);
        this.put("Конфеты", 1.2);
        this.put("Сыр", 1.0);
        items = new ArrayList<>(this.keySet());
    }
    String names() {
        int a = Tools.random(1, items.size());
        return items.get(a);
    }
}
