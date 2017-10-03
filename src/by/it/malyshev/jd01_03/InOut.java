package by.it.malyshev.jd01_03;

import java.util.Scanner;

public class InOut {

    static String getMyOneLine() {
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
        String line = InOut.getMyOneLine();
        double[] res = processOneLine(line);
        return res;
    }

    static void printArray(double[] arr) {
        for (double value : arr) {
            System.out.printf("%10.4f ", value);
        }
        System.out.println();
    }

    static double[][] getDouble2DArray() {
        System.out.println("Input row count");
        int rows = Integer.parseInt(InOut.getMyOneLine());
        double[][] res = new double[rows][];
        for (int i = 0; i < rows; i++) {
            String line = InOut.getMyOneLine();
            res[i] = processOneLine(line);
        }
        return res;
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
