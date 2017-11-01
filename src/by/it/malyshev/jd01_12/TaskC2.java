package by.it.malyshev.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Sergey Malyshev
 */

public class TaskC2 {

    public static void main(String[] args) {

        Integer[] intArrayI={1,3,1,2,5,3,4,2,0,0,0,2,4,5,7,9,7,6,5};
        List<Integer> a = Arrays.asList(intArrayI);
        List<Integer> arrayListIA=new ArrayList<>(a);
        System.out.println("\nМножество A\n"+arrayListIA);

        List<Integer> arrayListIB = new ArrayList<>(15);
        Random randomMark = new Random();
        for (int i = 0; i < 15; i++) {
            arrayListIB.add(randomMark.nextInt(10) + 1);
        }
        System.out.println("\nМножество B\n"+arrayListIB);

        Double[] intArrayD={1.,3.,1.,2.,5.,3.,4.,2.,0.,0.,0.,2.,4.,5.,7.,9.,7.,6.,5.};
        List<Double> aD = Arrays.asList(intArrayD);
        List<Double> arrayListDA=new ArrayList<>(aD);
        System.out.println("\nМножество C\n"+arrayListDA);

        List<Double> arrayListDB = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            arrayListDB.add((double)(randomMark.nextInt(10)+1));
        }
        System.out.println("\nМножество D\n"+arrayListDB);


        List<?> resCrossI=MyCollect.getCrossT(arrayListIA,arrayListIB);
        System.out.println("\nРезультат пересечения множеств A и B\n"+resCrossI);

        List<?> resCrossD=MyCollect.getCrossT(arrayListDA,arrayListDB);
        System.out.println("\nРезультат пересечения множеств C и D\n"+resCrossD);

        List<?> resUnionI=MyCollect.getUnionT(arrayListIA,arrayListIB);
        System.out.println("\nРезультат объединения множеств A и B\n"+resUnionI);

        List<?> resUnionD=MyCollect.getUnionT(arrayListDA,arrayListDB);
        System.out.println("\nРезультат объединения множеств C и D\n"+resUnionD+"\n");
    }

}
