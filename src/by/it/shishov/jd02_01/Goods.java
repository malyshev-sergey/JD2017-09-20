package by.it.shishov.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Сергей on 27.10.2017.
 */
public class Goods extends HashMap<String,Double>{
    static Goods items = new Goods();
    private List<String> names;
    public Goods() {
        this.put("Bread", 1.1);
        this.put("Milk", 1.5);
        this.put("Bear", 2.5);
        this.put("Vodka", 3.0);
        this.put("Water", 0.5);
        names  = new ArrayList<>(this.keySet());
    }

    String randomGood(){
        return  names.get(Helper.random(0,names.size()-1));
    }


}
