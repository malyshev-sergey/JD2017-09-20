package by.it.shelkovich.jd1_12;

import java.util.HashSet;
import java.util.Set;

public class MyCollectMultiType {
    static <T> Set<T> getUnion(Set<T> set1, Set<T> set2){
        Set<T> resultSet = new HashSet<>(set1);
        resultSet.addAll(set2);
        return resultSet;
    }

    static <T> Set<T> getCross(Set<T> set1, Set<T> set2){
        Set<T> resultSet = new HashSet<>(set1);
        resultSet.retainAll(set2);
        return resultSet;
    }
}
