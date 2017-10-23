package by.it.shishov.jd01_14;

import java.io.*;

/**
 * Created by Сергей on 23.10.2017.
 */
public class TaskA {
    public static void solveTaskA() throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/shishov/";
        String filename = src + "jd01_14/integer.dat";
        File f = new File(filename);


        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20 + 10));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                dos.close();
            }
        }
        try (DataInputStream inp = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(filename))
                )
        ) {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                sum = sum + i;
                count++;
                System.out.print(i + " ");
            }
            System.out.println("\nAverage=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
