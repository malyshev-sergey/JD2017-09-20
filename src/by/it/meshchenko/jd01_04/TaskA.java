package by.it.meshchenko.jd01_04;

import java.io.IOException;
import java.lang.reflect.Array;

/**
 * Created by user on 29.09.2017.
 */
public class TaskA {

    static void multiplicationTable(){
        System.out.println("A.1.\n Таблица умножения от 2 до 9:");
        for(int i = 2; i <= 9; i ++){
            for(int j = 2; j <= 9; j ++){
                System.out.printf("%-1d*%d=%-5d", i, j, i*j);
            }
            System.out.println();
        }
        System.out.println();
    }
    static void searchFirstLasstElements() throws IOException {
        double[] arr1 = InOut.createOneMass();
        double first = arr1[0];
        double last = arr1[arr1.length-1];
        InOut.printOneMass(arr1);
        Util.quickSort(arr1);
        InOut.printOneMass(arr1);
        System.out.println("Новые позиции элементов:");
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] == first) System.out.printf("first: arr1[%3d]=%-7.3f  ", i, arr1[i]);
            if(arr1[i] == last) System.out.printf("last: arr1[%3d]=%-7.3f  ", i, arr1[i]);
        }

    }

}
