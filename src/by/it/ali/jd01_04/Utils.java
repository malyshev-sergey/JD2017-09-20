package by.it.ali.jd01_04;

import java.util.Arrays;

/**
 * Created by user on 29.09.2017.
 */
public class Utils {
    static void Sort(int[] a){
        System.out.println("Отсортированный массив");
        int cols=0;
        int save=0;
        for (int j = 0; j<a.length ; j++) {


            for (int i = a.length - 1; i > j; i--) {

                if (a[i] < a[i - 1]) {
                    save = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = save;
                }

            }
            System.out.printf("[%-1d]=%-2d", j, a[j]);
            cols++;
            if (0==cols%4){System.out.println();}
        }
        System.out.println();
    }
}
