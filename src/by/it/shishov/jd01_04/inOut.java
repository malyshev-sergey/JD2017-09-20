package by.it.shishov.jd01_04;

import java.util.Scanner;

/**
 * Created by Сергей on 27.09.2017.
 */
public class inOut {
    /**
     *
     * @return возвращает строку, введенную с клавиатуры
     */
    public static String consoleReadLine(){
        System.out.println("Введите массив через пробел: ");
        String line = new Scanner(System.in).nextLine();
        return line;
    }

    /**
     *
     * @param line входная строка
     * @return возвращает массив чисел
     */
    public static double[] stringLineToDoubleArray(String line){
        String[] inputLine = line.split(" ");
        double[] doubleArr = new double[inputLine.length];
        for (int i = 0; i < inputLine.length; i++) {
            doubleArr[i] = Double.parseDouble(inputLine[i]);

        }
        return doubleArr;
    }

    /**
     *
     * @param arr входной массив
     * @param name название элементов массива
     * @param cols количество столбцов для вывода
     */
    public static void printArr(double[] arr, String name, int cols){

        int col = 0;
        System.out.println("\nВывод одномерного массива: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);
            System.out.printf("[%-2d] = % -9.1f", i, arr[i]);
            col++;
            if ((0 == col%cols) || (arr.length - 1 ==i)){
                System.out.println();
            }

        }
    }

    /**
     *
     * @param arr входной массив
     */
    public static void printArray2D(double[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%6.2f", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMultiplicationTable(){
        int col = 0;
        System.out.println("\nТаблица умножения : ");
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%2d ", i,j,i*j);
                col++;
                if (col % 8 == 0)
                    System.out.println();
            }
        }
    }


}
