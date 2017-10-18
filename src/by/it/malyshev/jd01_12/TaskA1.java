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

        Iterator<Integer> itrArrayListMarksAll = arrayListMarksAll.iterator();
        System.out.println("\nСписок школьных оценок");
        while (itrArrayListMarksAll.hasNext()) {
            System.out.print(itrArrayListMarksAll.next());
            if (itrArrayListMarksAll.hasNext()) System.out.print("; ");
        }

        itrArrayListMarks = arrayListMarks.iterator();
        System.out.println("\n\nСубсписок высоких оценок (>4)");
        while (itrArrayListMarks.hasNext()) {
            System.out.print(itrArrayListMarks.next());
            if (itrArrayListMarks.hasNext()) System.out.print("; ");
        }

        System.out.println();
    }

}
