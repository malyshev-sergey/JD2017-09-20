package by.it.akhmelev.jd01_03.classwork;

import java.util.Scanner;

public class InOut {

    static String getMyOneLine() {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        return line;
    }


    private static double[] processOneLine(String line) {
        String[] strMas = line.split(" ");
        double[] doubleMas = new double[strMas.length];
        for (int i = 0; i < doubleMas.length; i++) {
            doubleMas[i] = Double.parseDouble(strMas[i]);
        }
        return doubleMas;
    }

    static double[] getDoubleArray() {
        String line = InOut.getMyOneLine();
        double[] res = processOneLine(line);
        return res;
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

    static void printArray(double[] arr) {
        for (double value : arr) {
            System.out.printf("%10.4f ", value);
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int cols) {
        int index = 0;
        for (double value : arr) {
            System.out.printf("%s[%2d]=%10.4f ",
                                name, index, value);
            if (++index % cols == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }


    static void printArray(double[][] arr) {
        for (double[] r : arr) {
            for (double value : r) {
                System.out.printf("%10.4f ", value);
            }
            System.out.println();
        }
    }


}
