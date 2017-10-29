package by.it.shelkovich.jd1_15;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskA {
    static void run(){
        //int[][] matrix = new int[15][15];

        String pathStr = System.getProperty("user.dir") + "/src/by/it/shelkovich/jd1_15/";
        Path path = Paths.get(pathStr + "matrix.txt");

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path.toString())))) {
            int matrixElem;
            for (int i = 0; i < 4 ; i++) {
                for (int j = 0; j < 4; j++) {
                    matrixElem = (int)Math.round(Math.random()*30)-15;
                    System.out.printf("%3d ", matrixElem);
                    pw.printf("%3d ", matrixElem);
                }
                System.out.println();
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
