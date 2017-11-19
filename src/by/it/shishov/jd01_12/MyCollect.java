package by.it.shishov.jd01_12;

import java.util.*;

/**
 * Created by Сергей on 23.10.2017.
 */
public class MyCollect {
    static Set<Integer> getCross(Set<Integer> collectionA, Set<Integer> collectionB){
        Set<Integer> result = new HashSet<>(collectionA);
        result.retainAll(collectionB);
        return result;
    }

    static Set<Integer> getUnion(Set<Integer> collectionA, Set<Integer> collectionB){
        Set<Integer> result = new HashSet<>(collectionA);
        result.addAll(collectionB);
        return result;
    }
}
