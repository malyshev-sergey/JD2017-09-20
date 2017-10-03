package by.it.meshchenko.jd01_04;

import by.it.meshchenko.jd01_03.*;

import java.io.IOException;

/**
 * Created by user on 29.09.2017.
 */
public class InOut {
    private static int m, n, col;
    private static int[] arr;
    private static String line;

    static double[] createOneMass() throws IOException {
        double[] res = null;
        System.out.println("Введите размерность одномерного массива и число колонок (натуральные числа):");
        line = Util.getOneLine();
        arr = Util.lineToInArray(line);
        m = arr[0];
        if(arr.length < 2) col = arr.length;
        else col = arr[1];
        if(m > 0){
            res = new double[m];
            System.out.println("Введите элементы одномерного массива (или нажниме 'r',\n " +
                    "для случайной генерации элементов):");
            line = Util.getOneLine();
            if(line.compareTo("r") == 0){
                for(int i = 0; i < m; i++){
                    res[i] = Util.randomDouble(m);
                }
            }
            else{
                arr = Util.lineToInArray(line);
                for(int i = 0; i < m; i++){
                    res[i] = arr[i];
                }
            }
        }
        return res;
    }

    static void printOneMass(double[] arr){
        printOneMass(arr, col);
    }

    static void printOneMass(double[] arr, int col){
        System.out.println();
        if(arr != null){
            for(int i = 0; i < arr.length; i++){
                System.out.printf("arr[%3d]=%-9.3f  ", i, arr[i]);
                if((i+1) % col == 0){
                    System.out.println();
                }
            }
        }
        else{
            System.out.println("Ошибка задания размерности массива");
        }
        System.out.println();
    }

    static double[][] createTwoMass() throws IOException{
        double[][] res = null;
        System.out.println("Введите размерность двухмерного массива:");
        line = Util.getOneLine();
        arr = Util.lineToInArray(line);
        m = arr[0];
        n = arr[1];
        if(m > 0 && n > 0){
            res = new double[m][n];
            System.out.println("Введите элементы двухмерного массива (или нажниме 'r',\n " +
                    "для случайной генерации элементов):");
            line = Util.getOneLine();
            if(line.compareTo("r") == 0){
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        res[i][j] = Util.randomDouble(n);
                    }
                }
            }
            else{
                arr = Util.lineToInArray(line);
                int z = 0;
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        res[i][j] = arr[z];
                        z = z + 1;
                    }
                }
            }
        }
        return res;
    }

    static void printTwoMass(double[][] arr){
        System.out.println();
        if(arr != null){
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr[i].length; j++){
                    System.out.printf("%-7.3f  ", arr[i][j]);
                }
                System.out.printf("%n");
            }
        }
        else{
            System.out.println("Ошибка задания размерности массива");
        }
        System.out.println();
    }

}
