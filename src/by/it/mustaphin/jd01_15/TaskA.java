package by.it.mustaphin.jd01_15;

import java.io.*;

public class TaskA {

    void makeMatrix() {
        String src = System.getProperty("user.dir") + "/src/by/it/mustaphin/jd01_15/matrix.txt";
        File file = new File(src);
        try (PrintWriter printer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            for (int i = 0; i < 4; i++) {
                for (int k = 0; k < 4; k++) {
                    int vol = (int) (Math.random() * 10) + 1;
                    if (((int) (Math.random() * 10) + 1) > 5) {
                        vol *= -1;
                    }
                    System.out.printf("%-3d ", vol);
                    printer.printf("%-3d ", vol);
                }
                System.out.println();
                printer.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
