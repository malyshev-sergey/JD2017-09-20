package by.it.govor.jd01.jd01_12.TaskB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


public class Task2 {
    public static void task2() {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println();

        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            list.add(r.nextInt(11));

        }


        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(2);
        list2.add(1);
        list2.add(5);
        list2.add(8);
        list2.add(9);
        System.out.println(list2);
        int k = 0;
        Iterator<Integer> iter = list2.iterator();

        while (iter.hasNext() && list2.size()>1) {
            iter.next();
            k++;
            if (k == 2) {
                k = 0;
                iter.remove();

                iter=null;
            }
        }
        System.out.println(list2);
    }
}

