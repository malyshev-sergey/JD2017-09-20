package by.it.shelkovich.jd1_04;

import java.util.Arrays;

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
        //double oneLineArray[] = {15, 256, 23, 43, 54, 193, 12234, 1, 1225, 56, 67, 93, 45, 67, 911, 11111, 222, 44444, 55};
        InOut.printArray("first", oneLineArray, 5);
        double first = oneLineArray[0], last = oneLineArray[oneLineArray.length-1];

        System.out.println("\nОтсортированный массив:");
        Arrays.sort(oneLineArray);
        InOut.printArray("sorted", oneLineArray, 4);

        System.out.printf("\nПосле сортировки первый символ (%4.2f) находится" +
                "в позиции %d, а последний (%4.2f) на позиции %d\n", first, Arrays.binarySearch(oneLineArray, first), last, Arrays.binarySearch(oneLineArray, last));
    }



}
