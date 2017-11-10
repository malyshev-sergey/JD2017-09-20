package by.it.meshchenko.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Goods extends HashMap<String, Double> {

    static Goods items = new Goods();

    private List<String> names;

    public Goods() {
        this.put("Bread", 1.5);
        this.put("Apple", 2.4);
        this.put("Carrot", 0.8);
        this.put("Orange", 3.5);
        this.put("Buckwheat", 4.7);
        this.put("Almond", 25.3);
        this.put("Whater", 25.3);
        names = new ArrayList<>(this.keySet());
    }
    String randomGood(){
        return names.get(Helper.random(0,names.size()-1));
    }
}
