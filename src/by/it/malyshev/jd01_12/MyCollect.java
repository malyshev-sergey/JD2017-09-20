package by.it.malyshev.jd01_12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Malyshev
 */

class MyCollect {

    static List<Integer> getCross(List<Integer> a, List<Integer> b) {

        List<Integer> res = new ArrayList<>(a);
        res.retainAll(b);

        return res;
    }

    static List<Integer> getUnion(List<Integer> a, List<Integer> b) {

        List<Integer> res = new ArrayList<>(a);
        res.addAll(b);

        return res;
    }

    static<T> List<T> getCrossT(List<T> a, List<T> b) {

        List<T> res = new ArrayList<>(a);
        res.retainAll(b);

        return res;
    }

    static<T> List<T> getUnionT(List<T> a, List<T> b) {

        List<T> res = new ArrayList<>(a);
        res.addAll(b);

        return res;
    }
}
