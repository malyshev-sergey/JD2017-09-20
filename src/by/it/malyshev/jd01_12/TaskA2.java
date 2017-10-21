package by.it.malyshev.jd01_12;

import java.util.*;

/**
 * @author Sergey Malyshev
 */

public class TaskA2 {

    public static void main(String[] args) {

        Integer[] intArray={1,3,1,2,5,3,4,2,0,0,0,2,4,5,7,9,7,6,5};
        List<Integer> a = Arrays.asList(intArray);
        List<Integer> arrayListA=new ArrayList<>(a);
        System.out.println("\nМножество A\n"+arrayListA);

        List<Integer> arrayListB = new ArrayList<>(15);
        Random randomMark = new Random();
        for (int i = 0; i < 15; i++) {
            arrayListB.add(randomMark.nextInt(10) + 1);
        }
        System.out.println("\nМножество B\n"+arrayListB);

        List<Integer> resCross=MyCollect.getCross(arrayListA,arrayListB);
        System.out.println("\nРезультат пересечения множеств A и B\n"+resCross);

        List<Integer> resUnion=MyCollect.getUnion(arrayListA,arrayListB);
        System.out.println("\nРезультат объединения множеств A и B\n"+resUnion+"\n");
    }

}
