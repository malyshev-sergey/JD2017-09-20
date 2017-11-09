package by.it.malyshev.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Basket extends HashMap<String, Integer> {

    static final int basketCapacity = 4;

    boolean add(String chosenItem) {
        int counter = 0;
        for (Map.Entry<String, Integer> entry : this.entrySet())
            counter += entry.getValue();
        if (counter > basketCapacity) return false;
        else {
            if (this.containsKey(chosenItem))
                this.put(chosenItem, this.get(chosenItem) + 1);
            else this.put(chosenItem, 1);
        }
        return true;
    }

    double totalSum() {
        double res = 0;
        for (Map.Entry<String, Integer> entry : this.entrySet())
            res += entry.getValue() * Goods.items.get(entry.getKey());
        return res;
    }


}
