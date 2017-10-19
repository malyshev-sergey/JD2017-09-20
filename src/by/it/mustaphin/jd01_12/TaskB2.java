package by.it.mustaphin.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {

    int length = 200000;

    void process(List<Integer> humans) {
        for (int i = 1; i < length + 1; i++) {
            humans.add(i);
        }
        long iniTime = System.nanoTime();
        while (humans.size() > 1) {
            Iterator<Integer> itHumans = humans.iterator();
            boolean toLeft = false;
            while (itHumans.hasNext()) {
                itHumans.next();
                if (toLeft) {
                    itHumans.remove();
                    toLeft = false;
                    continue;
                }
                toLeft = true;
            }

//            System.out.println(humans);
        }
        System.out.println("Прошло времени " + (((double) System.nanoTime() - iniTime) / 1000));
    }

    void processArray() {
        process(new ArrayList<>());
    }

    void processLinked() {
        process(new LinkedList<>());
    }

}
