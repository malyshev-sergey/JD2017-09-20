package by.it.meshchenko.jd01_12;

import java.util.*;

public class MyCollect {
    /*
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
    */
    public static <T> LinkedHashSet<T> getCross(LinkedHashSet<T> a, LinkedHashSet<T> b){
        LinkedHashSet<T> result = new LinkedHashSet<>();
        Iterator<T> itA = a.iterator();
        while (itA.hasNext()){
            T i = itA.next();
            if(b.contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    public static <T> LinkedHashSet<T> getUnion(LinkedHashSet<T> a, LinkedHashSet<T> b){
        LinkedHashSet<T> result = new LinkedHashSet<>();
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

    public static String mapToString(Map<String, Integer> m){
        Iterator<Map.Entry<String, Integer>> itM = m.entrySet().iterator();
        StringBuilder str = new StringBuilder();
        while (itM.hasNext()){
            Map.Entry<String, Integer> temp = itM.next();
            str.append(temp.getKey() + ": " + temp.getValue().toString() + "\n");
        }
        return str.toString();
    }
}
