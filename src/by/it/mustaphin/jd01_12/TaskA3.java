package by.it.mustaphin.jd01_12;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskA3 {

    List<Integer> numbs = new LinkedList<>();

    void fillList() {
        for (int i = (int) (Math.random() * 100 + 10); i >= 0; i--) {
            if (i % 2 == 0)
                numbs.add((int) (Math.random() * 100));
            else
                numbs.add((int) (Math.random() * (-100)));
        }
        System.out.println(numbs);
    }

    void replace() {
        Iterator<Integer> itNumbs = numbs.iterator();
        while (itNumbs.hasNext()) {

            if (itNumbs.next() < 0) {
                itNumbs.remove();

            }
        }
    }
}
