package by.it.govor.jd02_03;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GootProduct  {
    HashMap<String,Double> Allproduct = new HashMap<>();
    private List<String> names= new ArrayList<>();
    public  void product() {
        Allproduct.put("Milk",0.75);
        Allproduct.put("Apple",0.25);
        Allproduct.put("Apricot",1.0);
        Allproduct.put("Beef",2.0);
        Allproduct.put("Water",0.3);
        Allproduct.put("Bread",0.1);
        Allproduct.put("Carp",4.0);
        Allproduct.put("Cheese",1.75);
        names.addAll(Allproduct.keySet());
    }

          HashMap<String,Double> gootproducts(int e){
        HashMap<String,Double> good = new HashMap<>();
        for (int i = 0; i <e; i++) {

            String s = names.get(NewRandom.random(0, names.size() - 1));
            good.put(s, Allproduct.get(s));


        }

        return good;
        }


        }



