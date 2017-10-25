package by.it.malyshev.jd01_15;

public class TaskA {

    public static void main(String[] args) {

        int[][] matrix = new int[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                matrix[i][j]=(int)(Math.random()*31)-15;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.printf("%3d ", matrix[i][j]);
            System.out.println();
        }

    } // main

} // TaskA
