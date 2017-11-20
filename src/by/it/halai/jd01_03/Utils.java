package by.it.halai.jd01_03;


class Utils {

    //Находим максимальное значение в одномерном массиве
    static void getMaxValue(double[] arr) {
        if (0 == arr.length) {
            System.out.println(Integer.MAX_VALUE);
        } else {
            double max = arr[0];
            for (double i : arr) {
                if (max < i) {
                    max = i;
                }
            }
            System.out.println(max);
        }
    }

    //Находим минимальное значение в одномерном массиве
    static void getMinValue(double[] arr) {
        if (0 == arr.length) {
            System.out.println(Integer.MIN_VALUE);
        } else {
            double min = arr[0];
            for (double i : arr) {
                if (min > i) {
                    min = i;
                }
            }
            System.out.println(min);
        }
    }

    //Сортировка одномерного массива по возрастанию или по убыванию значений
    static double[] sortArray(double[] arr, int numberOfChoice) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((numberOfChoice == 1 && arr[i] > arr[j]) || (numberOfChoice == 2 && arr[i] < arr[j])) {
                    double m = arr[i];
                    arr[i] = arr[j];
                    arr[j] = m;
                }
            }

        }
        return arr;
    }

}
