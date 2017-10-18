package by.it.malyshev.jd01_12;

import java.util.*;

public class TaskA3 {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>(30);
        Random randomMark = new Random();
        for (int i = 0; i < 30; i++) {
            a.add(randomMark.nextInt(21) - 10);
        }
        Iterator<Integer> itr=a.iterator();
        System.out.println("\n\nМножество A");
        while (itr.hasNext()) {
            System.out.print(itr.next());
            if (itr.hasNext()) System.out.print("; ");
        }

//        List<Integer> b = new LinkedList<>(a);





    }
}
