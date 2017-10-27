package by.it.akhmelev.jd02_01.classwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Goods extends HashMap<String,Double>{

    static Goods items=new Goods();

    private List<String> names;

    private Goods() {
        this.put("Bread",0.8);
        this.put("Milk",1.5);
        this.put("Beer",2.1);
        this.put("Vodka",10.1);
        this.put("Water",0.6);
        names=new ArrayList<>(this.keySet());
    }

    String randomGood(){
        return names.get(Helper.random(0,names.size()-1));
    }



}
