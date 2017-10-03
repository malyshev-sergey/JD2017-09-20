package by.it.malyshev.jd01_04;

import java.util.Scanner;

public class InOut {

    static String getOneLine() {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        return line;
    }

    static double[] processOneLine(String line) {
        String[] strMas = line.split(" ");
        double[] doublesMas = new double[strMas.length];
        for (int i = 0; i < doublesMas.length; i++) {
            doublesMas[i] = Double.parseDouble(strMas[i]);
        }
        return doublesMas;
    }

    static double[] getDoubleArray() {
        String line = InOut.getOneLine();
        double[] res = processOneLine(line);
        return res;
    }


    static String[] processOneLineToStrArr(String line) {
        String[] strMas = line.split(" ");
        return strMas;
    }

    static double[][] getDouble2DArray(int rows) {
        double[][] res = new double[rows][];
        for (int i = 0; i < rows; i++) {
            String line = InOut.getOneLine();
            res[i] = processOneLine(line);
        }
        return res;
    }


    static void printArray(double[] arr, String name, int cols) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d] =% -9.1f ", i, arr[i]);
            index++;
            if (index % cols == 0) System.out.println();
        }
        System.out.println();
    }

    static void print2DArray(double[][] arr) {
        for (double[] r : arr) {
            for (double value : r) {
                System.out.printf("%10.4f ", value);
            }
            System.out.println();
        }
    }

}
