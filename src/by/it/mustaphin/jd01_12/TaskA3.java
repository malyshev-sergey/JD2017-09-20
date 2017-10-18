package by.it.mustaphin.jd01_12;

import java.util.*;

public class TaskA3 {

    List<Integer> numbs = new LinkedList<>();

    void fillList() {
        for (int i = (int) (Math.random() * 100 + 10); i >= 0; i--) {
            if (i % 2 == 0)
                numbs.add((int) (Math.random() * 100));
            else
                numbs.add((int) (Math.random() * (-100)));
        }
    }

    void replace() {
        numbs.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (-1) * (o1 - o2);
            }
        });
        System.out.println(numbs);
    }
}
