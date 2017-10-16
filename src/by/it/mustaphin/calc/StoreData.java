package by.it.mustaphin.calc;

import java.util.*;

public class StoreData {

    private HashMap<String, Var> data=new HashMap<>();

    public StoreData() {
//        data = new TreeMap<>(keyComparator);
    }

    public void store(String name, Var var) {
        data.put(name, var);
        System.out.println(data.get(name));
    }

//    Comparator<String> keyComparator = (o1, o2) -> {
//        if (o1.contains("Add") & ((o2.contains("Sub") || (o2.contains("Div")) || (o2.contains("Mul"))))) {
//            return 1;
//        } else if (o1.contains("Div") & ((o2.contains("Add") || (o2.contains("Mul")) || (o2.contains("Sub"))))) {
//            return -1;
//        } else if (o1.contains("Mul") & ((o2.contains("Sub")) || (o2.contains("Div")))) {
//            return 1;
//        } else if (o1.contains("Mul") & (o2.contains("Add"))) {
//            return -1;
//        } else if (o1.contains("Sub") & ((o2.contains("Mul")) || (o2.contains("Add")))) {
//            return -1;
//        } else if (o1.contains("Sub") & (o2.contains("Div"))) {
//            return 1;
//        }
//        return 0;
//    };

    public void sortvar() {
//        SortedSet<String> keySorted = new TreeSet<>(keyComparator);
//        keySorted.addAll(data.keySet());
//        for (String key : keySorted) {
//            System.out.printf("%-11s = %s\n", key, (null == data.get(key)) ? "Выполнить операцию невозможно либо операция не реализована" : data.get(key));
//        }

//        for (Map.Entry<String, Var> me : data.entrySet()) {
//            System.out.println(me.getKey() + " " + me.getValue());
//        }

        Set<Map.Entry<String, Var>> dataSet = data.entrySet();
        Iterator<Map.Entry<String, Var>> itData = dataSet.iterator();
        while (itData.hasNext()) {
            Map.Entry<String, Var> me = itData.next();
            System.out.printf("%-11s = %s\n", me.getKey(), (null == me.getValue()) ? "Выполнить операцию невозможно либо операция не реализована" : me.getValue());
        }
    }

}
