package by.it.malyshev.jd01_12;

import java.util.*;

/**
 * @author Sergey Malyshev
 */

public class TaskA3 {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>(30);
        Random randomMark = new Random();
        for (int i = 0; i < 30; i++) {
            a.add(randomMark.nextInt(21) - 10);
        }

        List<Integer> res = new ArrayList<>(a);
        res.sort(Collections.reverseOrder());


        System.out.println("\nИсходная коллекция");
        System.out.println(a);

        System.out.println("\n\nОтрицательные элементы переставлены в конец");
        System.out.println(res);

    }
}
