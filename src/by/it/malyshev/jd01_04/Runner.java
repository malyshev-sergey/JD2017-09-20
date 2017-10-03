package by.it.malyshev.jd01_04;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

        System.out.println("Задание A1: вывод таблицы умножения");
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%2d ", i, j, i * j);
                if (j % 9 == 0) System.out.println();
            }
        }

        System.out.println("\n\nЗадание A2a: ввод и вывод в 5 колонок одномерного массива с названием и индексами");
        double[] oneDimDoubleArray = InOut.getDoubleArray();
        // 1 -2 56 -45 37 94 183 25 47 29 50
//        double[] oneDimDoubleArray = {1, -2, 56, -45, 37, 94, 183, 25, 47, 29,50};
        InOut.printArray(oneDimDoubleArray, "a", 5);

        System.out.println("\n\nЗадание A2b: пузырьковая сортировка того же массива по возрастанию и вывод его в 4 колонки");
        Utils.sortDoubleArray(oneDimDoubleArray, true);
        InOut.printArray(oneDimDoubleArray, "b", 4);

        System.out.println("\n\nЗадание A2с: вычисление новых (после сортировки) индексов первого и последнего элемента исходного массива");
        oneDimDoubleArray = new double[]{1, -2, 56, -45, 37, 94, 183, 25, 47, 29, 50};
        double firstElement = oneDimDoubleArray[0];
        double lastElement = oneDimDoubleArray[oneDimDoubleArray.length - 1];
        Utils.sortDoubleArray(oneDimDoubleArray, true);
        double newIndexOfFirstElement = linearSearch(oneDimDoubleArray, firstElement);
        double newIndexOfLastElement = linearSearch(oneDimDoubleArray, lastElement);
        System.out.println("Элемент 0 стал элементом  " + newIndexOfFirstElement);
        System.out.println("Элемент " + (oneDimDoubleArray.length - 1) + " стал элементом  " + newIndexOfLastElement);

        System.out.println("\n\nЗадание B:");
        System.out.println("Введите N число людей");
        int numberOfPeople = Integer.parseInt(InOut.getOneLine());
//        int numberOfPeople=4;
        System.out.println("Введите через пробел их фамилиии");
        String line = InOut.getOneLine();
        String[] namesOfPeople = InOut.processOneLineToStrArr(line);
//        Волк Заяц Дрозд Сыч
//        String[] namesOfPeople={"Волк","Заяц","Дрозд", "Сыч"};
        System.out.println("Введите двумерный массив их зарплат за 4 квартала (N строк и 4 столбца)");
        double[][] salary = InOut.getDouble2DArray(numberOfPeople);
//        2 5 4 1
//        1 3 2 1
//        2 1011 9 7
//        355 8 9 285
//        double[][] salary = {{2, 5, 4, 1},
//                {1, 3, 2, 1},
//                {2, 1011, 9, 7},
//                {355, 8, 9, 285}};
        System.out.println("\n\nТаблица доходов");
        printSalary(numberOfPeople, namesOfPeople, salary);

        System.out.println("\n\nЗадание С:\n");
        System.out.println("Исходный массив");
        double[] c = {34, 2, 1, 23, 4, 21, 41, 42, 13, 4};
        InOut.printArray(c, "c", 4);
        firstElement = c[0];
        lastElement = c[c.length - 1];
        Arrays.sort(c);
        System.out.println("\nМассив отсортированный методом sort() класса Arrays");
        InOut.printArray(c, "c", 4);
        System.out.println("\nметод binarySearch() класса Arrays");
        System.out.println("\nЭлемент 0 стал элементом  " + Arrays.binarySearch(c, firstElement));
        System.out.println("Элемент " + (c.length - 1) + " стал элементом  " + Arrays.binarySearch(c, lastElement) + "\n");


        c = new double[]{34, 2, 1, 23, 4, 21, 41, 42, 13, 4};
        double[] e = myMergeSort(c);
        System.out.println("\nМассив отсортированный методом myMergeSort()");
        InOut.printArray(c, "c", 4);

        System.out.println("\nметод myBinarySearch()");
        System.out.println("\nЭлемент 0 стал элементом  " + myBinarySearch(e, firstElement));
        System.out.println("Элемент " + (c.length - 1) + " стал элементом  " + myBinarySearch(e, lastElement) + "\n");

    }


    // TaskB
    static void printSalary(int numberOfPeople, String[] namesOfPeople, double[][] salary) {

        double totalSum = 0;
        System.out.printf("%-15s%11s%11s%11s%11s%10s", "Фамилия",
                "I кв.", "2 кв.", "3 кв.", "4 кв.", "Год");
        System.out.println();
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < salary[0].length; i++) {
            double sum = 0;
            System.out.printf("%-15s", namesOfPeople[i]);
            for (int j = 0; j < salary.length; j++) {
                sum = sum + salary[i][j];
                System.out.printf("%10.2f ", salary[i][j]);
            }
            System.out.printf("%10.2f ", sum);
            System.out.println();
            totalSum = totalSum + sum;
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("Итого%64.2f", totalSum);
        System.out.println();
    }

    //TaskC
    static double[] merge(double[] arr1, double[] arr2) {
        int i = 0;
        int j = 0;
        double[] res = new double[arr1.length + arr2.length];
        for (int k = 0; k < res.length; k++) {
            if (j < arr2.length && i < arr1.length) {
                if (arr1[i] > arr2[j]) res[k] = arr2[j++];
                else res[k] = arr1[i++];
            } else if (j < arr2.length) {
                res[k] = arr2[j++];
            } else {
                res[k] = arr1[i++];
            }
        }
        return res;
    }

    static double[] myMergeSort(double[] array) {
        if (array.length < 2) return array;
        int m = array.length / 2;
        return merge(myMergeSort(Arrays.copyOfRange(array, 0, m)),
                myMergeSort(Arrays.copyOfRange(array, m, array.length)));
    }

    static double linearSearch(double[] array, double k) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == k) return i;
        }
        return -1;
    }

    static int myBinarySearch(double[] array, double k) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (array[m] == k) return m;
            else if (array[m] > k) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

//    static void mergeSort(int[] array){
//        mergeSort(array,0,array.length-1);
//    }
}
