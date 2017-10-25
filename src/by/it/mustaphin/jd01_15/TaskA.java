package by.it.mustaphin.jd01_15;

import java.io.*;

public class TaskA {

    void makeMatrix() {
        String src = System.getProperty("user.dir") + "/src/by/it/mustaphin/jd01_15/matrix.txt";
        File file = new File(src);
        try (PrintWriter printer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            int newLine = 0;
            for (int i = -15; i <= 15; i++) {
                if (4 == newLine) {
                    System.out.println();
                    newLine = 0;
                }
                System.out.printf("%-3s ", i, newLine++);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
