package by.it.ali.jd01_12;

import java.util.HashSet;
import java.util.Iterator;

public class MyCollect {
    public static HashSet<Integer> a = new HashSet<>();
    public static HashSet<Integer> b = new HashSet<>();

     static void collects() {
        for (int i = 0; i < 30; i++) {
            a.add((int) (Math.random() * 30));
            b.add((int) (Math.random() * 30));
        }
        System.out.println("TaskA2");
        System.out.println("A: "+a);
        System.out.println("B: "+b);
    }

    static void getCross() {
        Iterator<Integer> iter = a.iterator();
        System.out.print("Пересечение множеств: ");
        while (iter.hasNext()) {
            Integer g=iter.next();
            if (b.contains(g)) {
                System.out.print(g+" ");
            }
        }
        System.out.println("");
    }
     static void getUnion() {
        Iterator<Integer> iter = a.iterator();
        System.out.println("Объединение множеств: ");
        while (iter.hasNext()) {
            Integer g=iter.next();
            if (b.contains(g)) {
                iter.remove();
            }
        }
        HashSet<Integer> c = new HashSet<>();
        c.addAll(a);
        c.addAll(b);
        System.out.println(c);
    }
}