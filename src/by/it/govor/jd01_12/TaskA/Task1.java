package by.it.govor.jd01_12.TaskA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.10.2017.
 */
public class Task1 {
    public static void task1(ArrayList<Integer> l) {
        List<Integer> f = new ArrayList<>();


        for (int i = 0; i <20 ; i++) {
            if (l.get(i)<4){
                f.add(l.get(i));
            }
        }
        System.out.println(l);
        System.out.println(f);
    }

}
