package by.it.malyshev.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {

    private static void printArray(double[] arr, String name, int cols) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d] =% -9.2f ", i, arr[i]);
            index++;
            if (index % cols == 0) System.out.println();
        }
        System.out.println("\n");

    } //printArray


    static void functionSeven(double start, double finish, double key) {

        double[] arrA = new double[((int) (random() * 21) + 20)];
        double step = (finish - start) / arrA.length;
        double counterD = start;
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = pow(pow(counterD, 2) + 4.5, 1. / 3);
            counterD += step;
        }
        printArray(arrA, "A", 5);

        int counter = 0;
        while (arrA[counter] <= key) {
            counter++;
        }
        double[] arrB = Arrays.copyOfRange(arrA, counter, arrA.length);
        printArray(arrB, "B", 5);

        double multB = 1;
        for (double value : arrB) {
            multB *= value;
        }
        double geometricMean = pow(multB, 1. / arrB.length);
        System.out.printf("Геометрическое среднее g массива B[] = % -9.2f\n", geometricMean);

    } //functionSeven

} //Task6
