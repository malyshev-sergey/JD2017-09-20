package by.it.shishov.jd01_04;

/**
 * Created by Сергей on 27.09.2017.
 */
public class Utils {

    /**
     * @param arr входной массив
     */
    public static void findMax(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("Максимальный элемент массива - это " + max);
    }

    /**
     * @param arr входной массив
     */
    public static void findMin(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("Минимальный элемент массива - это " + min);
    }

    /**
     * @param arr       входной массив
     * @param direction true - сортировка по возрастанию, false - сортировка по убыванию
     */
    public static double[] sortArr(double[] arr, boolean direction) {
        double buf;
        String result = " ";
        if (direction) {
            result = "по возрастанию";
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        buf = arr[j];
                        arr[j] = arr[i];
                        arr[i] = buf;
                    }
                }
            }
        } else if (!direction) {
            result = "по убыванию";
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] < arr[j]) {
                        buf = arr[j];
                        arr[j] = arr[i];
                        arr[i] = buf;
                    }
                }
            }
        }

        System.out.println("\n" + "Отсортированный массив " + result + ": ");
        for (double elem : arr
                ) {
            System.out.printf("->%2.1f", elem);
        }
        return arr;

    }

    /**
     *
     * @param arr входной массив
     */
    public static void findIndexes(double[] arr) {
        double firstIndex = arr[0], secondIndex = arr[arr.length - 1];
        Utils.sortArr(arr, true);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == firstIndex)
                System.out.println("\n" + "Новый индекс первого элемента массива = " + i);
            else if (arr[i] == secondIndex)
                System.out.println("\n" + "Новый индекс последнего элемента массива = " + i);
        }

    }

}
