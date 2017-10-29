package by.it.malyshev.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

        String dir = System.getProperty("user.dir") + "/src/by/it/malyshev/jd01_14/matrix.txt";

        try (PrintWriter prt=new PrintWriter(new FileWriter(dir,true))) {

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++)
                    prt.printf("%3d ", matrix[i][j]);
                prt.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    } // main

} // TaskA
