package by.it.dubrova.jd01_12;

import java.util.*;

public class MyCollect {
    public static Set getCross(Set a, Set b){
        a.retainAll(b); // возвращает пересечение множеств
        return a;
    }

    public static Set getUnion(Set a, Set b){
        a.addAll(b);
        return a;
    }
}
