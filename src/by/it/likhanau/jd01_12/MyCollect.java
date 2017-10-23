package by.it.likhanau.jd01_12;

import java.util.Iterator;
import java.util.List;

/**
 * Created by NotePad.by on 19.10.2017.
 */
public class MyCollect {
    public static List<Integer> getUnion(List<Integer> list, List<Integer> list2) {
        list.addAll(list2);
        return list;
    }

    public static void getCross(List<Integer> list, List<Integer> list2) {
        System.out.println("There are two collections of numbers: \n" + list + "\n" + list2);
        System.out.println("The same numbers are: ");
        list.retainAll(list2);
        System.out.println(list);
    }
}
