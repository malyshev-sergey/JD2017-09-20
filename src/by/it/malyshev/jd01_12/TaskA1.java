package by.it.malyshev.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    public static void main(String[] args) {

        List<Integer> arrayListMarks = new ArrayList<>(30);
        Random randomMark = new Random();
        for (int i = 0; i < 30; i++) {
            arrayListMarks.add(randomMark.nextInt(10) + 1);
        }

        List<Integer> arrayListMarksAll=new ArrayList<>(arrayListMarks);

        Iterator<Integer> itrArrayListMarks = arrayListMarks.iterator();
        while (itrArrayListMarks.hasNext()) {
            if (itrArrayListMarks.next() < 5) itrArrayListMarks.remove();
        }

        System.out.println("\nСписок школьных оценок\n"+arrayListMarksAll);

        System.out.println("\nСубсписок высоких оценок (>4)\n"+arrayListMarks);

        System.out.println();
    }

}
