package by.it.mustaphin.jd01_12;

import java.util.HashSet;
import java.util.Set;

public class MyCollect {

    static Set<Integer> setA = new HashSet<>();
    static Set<Integer> setB = new HashSet<>();

    static {
        for (int i = 0; i < 100; i++) {
            setA.add((int) (Math.random() * 100));
            setB.add((int) (Math.random() * 100));
        }
    }

    static void getCross() {
        start:
        for (int numA : setA) {
            for (int numB : setB) {
                if (numA == numB) {
                    System.out.print(numA + " ");
                    continue start;
                }
            }
        }
        System.out.println();
    }

    static void getUnion() {
        setA.addAll(setB);
        System.out.println(setA);
        System.out.println();
    }

}
