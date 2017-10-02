package by.it.mustaphin.jd01_03;

import java.util.Scanner;

class InOut {

    static private Scanner sc = new Scanner(System.in);

    static double[] in1D() {
        System.out.println("Введите числа типа double отделяя пробелом");
        String line = sc.nextLine();
        String[] strMas = line.split(" ");
        double[] numbMas = new double[strMas.length];
        for (int i = 0; i < strMas.length; i++) {
            numbMas[i] = Double.parseDouble(strMas[i]);
        }
        return numbMas;
    }

    static double[][] in2D() {
        double[][] mas = new double[7][7];
        for (int i = 0; i < mas.length; i++) {
            for (int k = 0; k < mas[i].length; k++) {
                mas[i][k] = Math.random() * 10;
            }
        }
        return mas;
    }

    static void out1D(double mas[], String name, int cols) {
        int col = 0;
        for (int i = 0; i < mas.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d]=%-4.2f  ", i, mas[i]);
            col++;
            if ((col == cols) || (mas.length - 1 == i)) {
                System.out.println();
            }
        }
    }

    static void out2D(double mas[][], String name, int rows) {
        for (int i = 0; i < mas.length; i++) {
            int row = 0;
            for (int k = 0; k < mas[i].length; k++) {
                System.out.printf(name + "[% -3d][% -3d]=%-4.2f ", i, k, mas[i][k]);
                row++;
                if ((row == rows) || (mas[i].length - 1 == k)) {
                    System.out.println();
                    row = 0;
                }
            }
            System.out.println("##############################################################################");
        }
    }

}
