package by.it.likhanau.jd01_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Util {
    static String readLine() {
        InputStreamReader isReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isReader);
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return line;
    }

    static double findMinDouble(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        return min;
    }


    static double findMaxDouble(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) max = array[i];
        }
        return max;
    }


    static void mergeSort(double[] array) {
        mergeSort(array, 0, array.length - 1, true);
    }


    static void mergeSort(double[] array, boolean upDirection) {
        mergeSort(array, 0, array.length - 1, upDirection);
    }

    private static void mergeSort(double[] sourceArray, int startPos, int endPos, boolean upDirection) {

        if (endPos <= startPos) return;
        int mid = startPos + (endPos - startPos) / 2;
        mergeSort(sourceArray, startPos, mid, upDirection);
        mergeSort(sourceArray, mid + 1, endPos, upDirection);

        double[] first = new double[mid - startPos + 1];
        System.arraycopy(sourceArray, startPos, first, 0, first.length);

        double[] second = new double[endPos - (mid + 1) + 1];
        System.arraycopy(sourceArray, mid + 1, second, 0, second.length);

        double[] result = new double[first.length + second.length];
        int fI = 0;
        int sI = 0;
        int rI = 0;
        boolean condition;

        while (fI < first.length && sI < second.length) {
            if (upDirection) condition = first[fI] < second[sI];
            else condition = first[fI] > second[sI];

            if (condition) {
                result[rI] = first[fI];
                fI++;
            } else {
                result[rI] = second[sI];
                sI++;
            }
            rI++;
        }

        if (fI == first.length) System.arraycopy(second, sI, result, rI, second.length - sI);
        else if (sI == second.length) System.arraycopy(first, fI, result, rI, first.length - fI);

        System.arraycopy(result, 0, sourceArray, startPos, result.length);

    }

    static int binarySearch(double[] array, double toFind) {
        int leftPos = 0;
        int rightPos = array.length;

        while (leftPos <= rightPos) {
            int midPos = (rightPos + leftPos) / 2;
            if (toFind == array[midPos]) return midPos;
            else {
                if (toFind < array[midPos]) rightPos = midPos - 1;
                else leftPos = midPos + 1;
            }
        }

        return -1;
    }


}

