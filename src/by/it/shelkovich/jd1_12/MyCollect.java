package by.it.shelkovich.jd1_12;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyCollect {
    static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> resultSet = new HashSet<>(set1);
        resultSet.addAll(set2);
        return resultSet;
    }

    static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> resultSet = new HashSet<>(set1);
        resultSet.retainAll(set2);

        /*Iterator<Integer> iter = set1.iterator();
        while(iter.hasNext()){
            Integer i = iter.next();
            if (set2.contains(i)) resultSet.add(i);
        }*/
        return resultSet;
    }
}
