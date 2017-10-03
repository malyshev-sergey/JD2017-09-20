package by.it.halai.jd01_04;


public class Utils {

    //сортировка массива слиянием
    static double[] merge(double[] arr1, double[] arr2) {
        int i = 0;
        int j = 0;
        double[] res = new double[arr1.length + arr2.length];
        //дописать код
        return res;
    }

    static double[] mergeSort(double[] arr, int l, int r) {

        int m = (l + r) / 2;
        return merge(mergeSort(arr, l, m), mergeSort(arr, m + 1, r));
    }

    static void mergeSort(double[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }


}
