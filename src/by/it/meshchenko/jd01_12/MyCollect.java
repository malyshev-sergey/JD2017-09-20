package by.it.meshchenko.jd01_12;

import java.util.HashSet;
import java.util.Iterator;

public class MyCollect {
    public static HashSet<Integer>  getCross(HashSet<Integer> a, HashSet<Integer> b){
        HashSet<Integer> result = new HashSet<>();
        Iterator<Integer> itA = a.iterator();
        while (itA.hasNext()){
            int i = itA.next();
            if(b.contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    public static HashSet<Integer> getUnion(HashSet<Integer> a, HashSet<Integer> b){
        HashSet<Integer> result = new HashSet<>();
        result.addAll(a);
        result.addAll(b);
        return result;
    }

    public static String printHashSet(HashSet<Integer> a){
        Iterator<Integer> itA = a.iterator();
        StringBuilder str = new StringBuilder();
        while (itA.hasNext()){
            int i = itA.next();
            str.append(i + ", ");
        }
        return str.toString();
    }
}
