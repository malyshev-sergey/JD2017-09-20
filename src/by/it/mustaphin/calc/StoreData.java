package by.it.mustaphin.calc;

import java.util.*;

public class StoreData {

    //    private HashMap<String, Var> data = new HashMap<>();
    private SortedMap<String, Var> data;

    public StoreData() {
//        data = new TreeMap(keyComparator);
        data = new TreeMap();
    }

    public void store(String name, Var var) {
        data.put(name, var);
    }

//    Comparator<Map.Entry<String, Var>> keyComparator = new Comparator<Map.Entry<String, Var>>() {
//        @Override
//        public int compare(Map.Entry<String, Var> o1, Map.Entry<String, Var> o2) {
//            if (o1.getKey().contains("Add") & ((o2.getKey().contains("Sub") || (o2.getKey().contains("Div")) || (o2.getKey().contains("Mul"))))) {
//                return 1;
//            } else if (o1.getKey().contains("Div") & ((o2.getKey().contains("Add") || (o2.getKey().contains("Mul")) || (o2.getKey().contains("Sub"))))) {
//                return -1;
//            } else if (o1.getKey().contains("Mul") & ((o2.getKey().contains("Sub")) || (o2.getKey().contains("Div")))) {
//                return 1;
//            } else if (o1.getKey().contains("Mul") & (o2.getKey().contains("Add"))) {
//                return -1;
//            } else if (o1.getKey().contains("Sub") & ((o2.getKey().contains("Mul")) || (o2.getKey().contains("Add")))) {
//                return -1;
//            } else if (o1.getKey().contains("Sub") & (o2.getKey().contains("Div"))) {
//                return 1;
//            }
//            return 0;
//        }
//    };

    public void sortvar() {

//        SortedSet<String> keySorted = new TreeSet<>();
//        keySorted.addAll(data.keySet());
//        for (String key : keySorted) {
//            System.out.printf("%-11s = %s\n", key, (null == data.get(key)) ? "Выполнить операцию невозможно либо операция не реализована" : data.get(key));
//        }

        Set<Map.Entry<String, Var>> dataSet = data.entrySet();
        Iterator<Map.Entry<String, Var>> itData = dataSet.iterator();
        while (itData.hasNext()) {
            Map.Entry<String, Var> me = itData.next();
            System.out.printf("%-11s = %s\n", me.getKey(), (null == me.getValue()) ? "Выполнить операцию невозможно либо операция не реализована" : me.getValue());
        }
    }
}
