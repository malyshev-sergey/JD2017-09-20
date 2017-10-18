package by.it.mustaphin.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskB2 {

    int length = 200000;

    void processArray() {
        List<Integer> humans = new ArrayList<>(length);
        for (int i = 1; i < length + 1; i++) {
            humans.add(i);
        }
        Iterator<Integer> itHumans = humans.iterator();
        while (humans.size() > 1) {
            int count = 0;
            while (itHumans.hasNext()) {
                System.out.println(itHumans.next());
                if (count % 2 != 0) {
                    itHumans.remove();
                }
                count++;
            }
        }
        System.out.println("Размер списка " + humans.size());
    }

}
