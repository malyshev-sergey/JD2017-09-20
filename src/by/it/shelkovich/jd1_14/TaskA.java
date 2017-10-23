package by.it.shelkovich.jd1_14;

import java.io.*;

public class TaskA {
    static void run() {
        File f = new File(Util.getLocalPath(), "taskAFile.bin");
        write(f);
        read(f);
    }

    private static void write(File f) {
        try (DataOutputStream os = new DataOutputStream(new FileOutputStream(f))) {
            for (int i = 0; i < 20; i++) {
                os.writeInt((int) (Math.random() * 10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(File f) {
        try (DataInputStream is = new DataInputStream(new BufferedInputStream(new FileInputStream(f)))) {
            int summ = 0;
            int count = 0;
            while (is.available() > 0) {
                int i = is.readInt();
                System.out.println(i);
                summ += i;
                count++;
            }
            System.out.println("Среднее арифметическое: " + summ / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
