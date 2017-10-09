package by.it.meshchenko.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

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
        String[] strArray = line.trim().split(" ");
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

    //Поиск минимального
    static double minInArray(double[] arr){
        double res = Double.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < res){
                res = arr[i];
            }
        }
        return res;
    }

    //Поиск максимального
    static double maxInArray(double[] arr){
        double res = Double.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > res){
                res = arr[i];
            }
        }
        return res;
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

    //Метод умножения двух матриц
    //A[m x n] * B[n x k] = C[m x k]
    static double[][] MxM(double[][] m1, double[][] m2){
        double[][] res = null;
        if(m1 != null && m2 !=null){
            int m = m1.length;
            int n1 = m1[0].length;
            int n2 = m2.length;
            int k = m2[0].length;
            if(m > 0 && n1 > 0 && n2 > 0 && k > 0 && n1 == n2){
                res = new double[m][k];
                for(int ci = 0; ci < m; ci++){
                    for(int cj = 0 ; cj < k; cj++){
                        for(int n = 0; n < n1; n++){
                            res[ci][cj] =  res[ci][cj] + m1[ci][n] * m2[n][cj];
                        }
                    }
                }
            }
        }

        return  res;
    }
}
