package by.it.ali.jd01_15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskA {


    static void SolveTaskA() {
        String src = System.getProperty("user.dir") + "/src/by/it/ali/";
        String out = src + "jd01_15/out.txt";
        try (PrintWriter printer = new PrintWriter(out)) {
            ArrayList<Integer> matr = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                Integer key = -15 + (int) (Math.random() * 30);
                matr.add(i, key);
            }
            for (int i = 0; i < 13; i = i + 4) {
                System.out.printf("{%4d%4d%4d%4d}\n", matr.get(i), matr.get(i + 1), matr.get(i + 2), matr.get(i + 3));
            }
               for (int i = 0; i < 13; i = i + 4) {
                printer.printf("{%4d%4d%4d%4d}\n", matr.get(i), matr.get(i + 1), matr.get(i + 2), matr.get(i + 3));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
