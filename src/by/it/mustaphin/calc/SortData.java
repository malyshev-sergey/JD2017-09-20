package by.it.mustaphin.calc;

import java.util.*;

public class SortData {

    static private HashMap<String, Var> data = new HashMap<>();

    public void store(String name, Var var) {
        data.put(name, var);
    }

    static void sortvar() {
        SortedMap<String, Var> dataSorted = new TreeMap(data);
        Set<Map.Entry<String, Var>> dataSet = dataSorted.entrySet();
        Iterator<Map.Entry<String, Var>> itData = dataSet.iterator();
        while (itData.hasNext()) {
            Map.Entry<String, Var> me = itData.next();
            System.out.printf("%-11s = %s\n", me.getKey(), (null == me.getValue()) ? "Выполнить операцию невозможно либо операция не реализована" : me.getValue());
        }
    }

    static public void printvar() {
        for (Map.Entry<String, Var> couple : data.entrySet()) {
            System.out.printf("%-11s\n", couple.getKey());
        }
    }
}
