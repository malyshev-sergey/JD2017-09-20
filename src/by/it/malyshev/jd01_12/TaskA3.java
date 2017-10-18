package by.it.malyshev.jd01_12;

import java.util.*;

public class TaskA3 {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>(30);
        Random randomMark = new Random();
        for (int i = 0; i < 30; i++) {
            a.add(randomMark.nextInt(21) - 10);
        }

        List<Integer> res = new ArrayList<>(a);
        Iterator<Integer> itr = res.iterator();
        while (itr.hasNext()) {
            if (itr.hasNext() && itr.next() < 0) itr.remove();
        }
       List<Integer> aLeft = new ArrayList<>(a);
        itr = aLeft.iterator();
        while (itr.hasNext()) {
            if (itr.hasNext() && itr.next() >= 0) itr.remove();
        }

        res.addAll(aLeft);

        aLeft.clear();

        System.out.println("\nИсходная коллекция");
        System.out.println(a);

        System.out.println("\n\nОтрицательные элементы переставлены в конец");
        System.out.println(res);

    }
}
