package by.it.malyshev.jd01_12;

import java.util.ArrayList;
import java.util.List;

class MyCollect {

    static List<Integer> getCross(List<Integer> a, List<Integer> b) {

        List<Integer> res = new ArrayList<>(a);
        res.retainAll(b);

        return res;
    }

    static List<Integer> getUnion(List<Integer> a, List<Integer> b) {

        List<Integer> res = new ArrayList<>(a.size() + b.size());
        res.addAll(a);
        res.addAll(b);

        return res;
    }

}
