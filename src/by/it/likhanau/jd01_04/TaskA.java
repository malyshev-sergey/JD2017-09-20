package by.it.likhanau.jd01_04;

import java.util.Arrays;

/**
 * Created by NotePad.by on 07.10.2017.
 */
public class TaskA {
    static void printMultiplyTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d * %d = %-2d  ", i, j, i*j);
            }
            System.out.println();
        }
    }

    static void run(){
        printMultiplyTable();

        double[] oneLineArray = InOut.readArray();
        InOut.printArray("initial", oneLineArray, 5);
        double initial = oneLineArray[0], ending = oneLineArray[oneLineArray.length-1];

        System.out.println("Sorted array:");
        Arrays.sort(oneLineArray);
        InOut.printArray("final", oneLineArray, 4);

        System.out.printf("The first number (%4.2f) is in position %d, and the last number (%4.2f) is in position %d", initial, Arrays.binarySearch(oneLineArray, initial),
        ending, Arrays.binarySearch(oneLineArray, ending));
    }



}

