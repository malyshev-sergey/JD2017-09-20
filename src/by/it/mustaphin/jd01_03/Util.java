package by.it.mustaphin.jd01_03;

class Util {

    static void boubleSort(double mas[], boolean UpDirection) {
        System.out.println("Сортировака массива");
        for (int i = mas.length - 1; i > 0; i--) {
            for (int k = 0; k < i; k++) {
                if (UpDirection) {
                    if (mas[k] < mas[k + 1]) {
                        double swap = mas[k];
                        mas[k] = mas[k + 1];
                        mas[k + 1] = swap;
                    }
                } else {
                    if (mas[k] > mas[k + 1]) {
                        double swap = mas[k];
                        mas[k] = mas[k + 1];
                        mas[k + 1] = swap;
                    }
                }
            }
        }
    }

    static double fintMinMax(double mas[], boolean max) {
        System.out.println("Поиск минимума/максимума");
        double looking = 0.0;
        for (int i = 0; i < mas.length; i++) {
            if (max) {
                if (mas[i] > mas[i + 1]) {
                    looking = mas[i];
                }
            } else {
                if (mas[i] < mas[i + 1]) {
                    looking = mas[i];
                }
            }
        }
        return looking;
    }

//    public static void multipleMatrix(double[][] mas1, double[][] mas2) {
//        double[][] newMatrix = new double[3][3];
//        for (int i = 0; i < mas1.length; i++) {
//            for (int k = 0; k < mas1[i].length; k++) {
//
//            }
//        }
//    }

}
