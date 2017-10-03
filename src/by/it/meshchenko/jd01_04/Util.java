package by.it.meshchenko.jd01_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by user on 29.09.2017.
 */
public class Util {
    static String getOneLine() throws IOException {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        String line = stin.readLine();
        //stin.close();
        return line;
    }

    //Преобразование строки в массив
    static int[] lineToInArray(String line){
        //дедение строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
        //создаём и заполняем массив чисел
        int[] array = new int[strArray.length];
        for(int i = 0; i < strArray.length; i++){
            array[i] = Integer.parseInt(strArray[i]);
        }
        return array;
    }

    //Преобразование строки в число
    static int lineToInt(String line){
        //дедение строки на элементы массива по пробелам
        String[] strArray = line.trim().split(" ");
        return Integer.parseInt(strArray[0]);
    }

    static double randomDouble(int n) {
        double start = -n;
        double end = n;
        double random = new Random().nextDouble();
        double result = start + (random * (end - start));
        return result;
    }

    static void quickSort(double[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        doSort(arr, startIndex, endIndex);
    }

    private static void doSort(double[] arr, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (arr[i] <= arr[cur])) {
                i++;
            }
            while (j > cur && (arr[cur] <= arr[j])) {
                j--;
            }
            if (i < j) {
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(arr, start, cur);
        doSort(arr, cur +1, end);
    }
}
