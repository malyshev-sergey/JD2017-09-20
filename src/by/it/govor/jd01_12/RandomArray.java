package by.it.govor.jd01_12;

import java.util.ArrayList;
import java.util.Random;

class RandomArray {
    static ArrayList<Integer> randomArrayInt() {
       ArrayList<Integer> l = new ArrayList<>();
       for (int i = 0; i <20 ; i++) {
           Random r = new Random();
           l.add(r.nextInt(11));

       }
       return l;
   }

}
