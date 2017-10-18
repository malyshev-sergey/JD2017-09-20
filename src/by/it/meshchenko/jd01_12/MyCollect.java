package by.it.meshchenko.jd01_12;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MyCollect {
    public static LinkedHashSet<Integer> getCross(LinkedHashSet<Integer> a, LinkedHashSet<Integer> b){
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        Iterator<Integer> itA = a.iterator();
        while (itA.hasNext()){
            int i = itA.next();
            if(b.contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    public static LinkedHashSet<Integer> getUnion(LinkedHashSet<Integer> a, LinkedHashSet<Integer> b){
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        result.addAll(a);
        result.addAll(b);
        return result;
    }

    public static String collectionToString(Collection<Integer> a){
        Iterator<Integer> itA = a.iterator();
        StringBuilder str = new StringBuilder();
        while (itA.hasNext()){
            int i = itA.next();
            str.append(i + ", ");
        }
        if(str.length() > 2) str.replace(str.length()-2,str.length(), "");
        return str.toString();
    }
}
