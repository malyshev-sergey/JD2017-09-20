package by.it.akhmelev.jd01_04.classwork;

import java.util.Arrays;

public class Runner {
    private static int[] merge(int[] arr1, int[] arr2) {
        int i1 = 0, i2 = 0;
        int[] res = new int[arr1.length + arr2.length];
        //тут нужен код для слияния
        return res;
    }

    private static int[] mergeSort(int[] array, int l, int r) {
        if (l == r) return new int[]{array[l]};
        int m = (l + r) / 2;
        return merge(mergeSort(array, l, m), mergeSort(array, m + 1, r));
    }

    private static int[] mergeSort(int[] array) {
        return array.length == 0 ? array : mergeSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 34, 23, 4, 21, 41, 4, 13, 42};
        int[] res = mergeSort(a);
        System.out.println(Arrays.toString(res));
    }
}
