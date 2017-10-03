package by.it.halai.jd01_03;


import java.util.Scanner;

class InOut {

    //Чтение одной строки
    static String getOneLine() {
        String line = new Scanner(System.in).nextLine();
        return line;
    }

    //Преобразование строки в одномерный массив
    static double[] lineToDoubleArray(String line) {
        String[] strArray = line.split(" ");     //деление строки на элементы массива по пробелам
        double[] array = new double[strArray.length];  //создаем массив нужного типа и размера
        for (int i = 0; i < strArray.length; i++) {        //заполняем полученный массив элементами нужного типа
            array[i] = Double.parseDouble(strArray[i]);
        }
        return array;
    }

    //Вывод на консоль одномерного массива
    static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("[% -3d]= %-4.2f ", i, array[i]);
        }
        System.out.println();
    }

    //преобразование одной строки в  целое число
    static int getNumberOfStr(String str) {
        int number = Integer.parseInt(str);
        return number;
    }

    //Заполняем двумерный массив
    static double[][] lineToArray2D(int number1, int number2) {
        double[][] arr2D = new double[number1][number2];
        for (int i = 0; i < number1; i++) {
            for (int j = 0; j < number2; j++) {
                System.out.println("Введите число " + (i + 1) + "-й строки " + (j + 1) + "-го столбца двумерного массива");
                String line = InOut.getOneLine();
                double num = Double.parseDouble(line);
                arr2D[i][j] = num;
            }
        }
        return arr2D;
    }

    //Вывод на консоль двумерного массива
    static void printArray(double[][] arr2D) {
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[0].length; j++) {
                System.out.printf("[%1d,%1d]=%-4.2f ", i, j, arr2D[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
