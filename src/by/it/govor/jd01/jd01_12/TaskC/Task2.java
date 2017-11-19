package by.it.govor.jd01.jd01_12.TaskC;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by User on 24.10.2017.
 */
public class Task2  {
    public static void getCross( ArrayList<Integer> l, ArrayList<Integer> d)  {
        System.out.println(d);
        System.out.println(l);
        HashSet<Integer> povtor = new HashSet<>();
        System.out.println("Повтор");
        for (Integer a:l) {
            for (Integer b:d) {
                if (a.equals(b)) {
                    povtor.add(a);
                }
            }
        }
        System.out.println(povtor);
    }

    public static void getUnion(ArrayList<Integer> l,ArrayList<Integer> d) {
        l.addAll(d);
        HashSet<Integer> noDuplicate = new HashSet<>(l);
        System.out.println(noDuplicate+" без повторений");
    }


}
