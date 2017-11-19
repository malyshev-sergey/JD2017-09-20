package by.it.shishov.jd01_15;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Сергей on 18.11.2017.
 */
public class TaskA {
    private final static int SIZE = 4;

    static void solveTaskA(){
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/JavaProjects/JD2017-09-20/src/by/it/shishov/jd01_15/matrix.txt")))) {
            int el;
            for (int i = 0; i < SIZE ; i++) {
                for (int j = 0; j < SIZE; j++) {
                    el = (int)Math.round(Math.random()*30)-15;
                    System.out.printf("%3d ", el);
                    pw.printf("%3d ", el);
                }
                System.out.println();
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
