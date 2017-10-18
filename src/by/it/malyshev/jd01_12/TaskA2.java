package by.it.malyshev.jd01_12;

import java.util.*;

public class TaskA2 {

    public static void main(String[] args) {

        Integer[] intArray={1,3,1,2,5,3,4,2,0,0,0,2,4,5,7,9,7,6,5};
        List<Integer> a = Arrays.asList(intArray);
        List<Integer> arrayListA=new ArrayList<>(a);
        Iterator<Integer> itr=arrayListA.iterator();
        System.out.println("\nМножество A");
        while (itr.hasNext()) {
            System.out.print(itr.next());
            if (itr.hasNext()) System.out.print("; ");
        }

        List<Integer> arrayListB = new ArrayList<>(15);
        Random randomMark = new Random();
        for (int i = 0; i < 15; i++) {
            arrayListB.add(randomMark.nextInt(10) + 1);
        }
        itr=arrayListB.iterator();
        System.out.println("\n\nМножество B");
        while (itr.hasNext()) {
            System.out.print(itr.next());
            if (itr.hasNext()) System.out.print("; ");
        }


        List<Integer> resCross=MyCollect.getCross(arrayListA,arrayListB);
        itr=resCross.iterator();
        System.out.println("\n\nРезультат пересечения множеств A и B");
        while (itr.hasNext()) {
            System.out.print(itr.next());
            if (itr.hasNext()) System.out.print("; ");
        }

        List<Integer> resUnion=MyCollect.getUnion(arrayListA,arrayListB);
        itr=resUnion.iterator();
        System.out.println("\n\nРезультат объединения множеств A и B");
        while (itr.hasNext()) {
            System.out.print(itr.next());
            if (itr.hasNext()) System.out.print("; ");
        }

        System.out.println();
    }

}
