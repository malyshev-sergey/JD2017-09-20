package by.it.malyshev.jd02_03;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

class Basket extends HashMap<String, Integer> {

    static LinkedBlockingQueue<Basket> baskets = new LinkedBlockingQueue<>(Dispatcher.basketsQuant);

    private int num;
    static final int basketCapacity = 4;

    Basket(int num) {
        this.num = num;
    }


    void add(String chosenItem) {
        int counter = 0;
        for (Entry<String, Integer> entry : this.entrySet())
            counter += entry.getValue();
        if (counter <= basketCapacity) {
            if (this.containsKey(chosenItem))
                this.put(chosenItem, this.get(chosenItem) + 1);
            else this.put(chosenItem, 1);
        }
    }

    double totalSum() {
        double res = 0;
        for (Entry<String, Integer> entry : this.entrySet())
            res += entry.getValue() * Goods.items.get(entry.getKey());
        return res;
    }

    String printContent() {
        StringBuilder str = new StringBuilder();
        for (Entry<String, Integer> entry : this.entrySet())
            str.append(String.format("%-8s %5.2f %2d psc\n", entry.getKey(), Goods.items.get(entry.getKey()), entry.getValue()));
        return str.toString();
    }


    @Override
    public String toString() {
        return "Basket №" + num;
    }


}
