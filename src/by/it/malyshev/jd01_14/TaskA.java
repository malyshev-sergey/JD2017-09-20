package by.it.malyshev.jd01_14;

import java.io.*;

public class TaskA {

    public static void main(String[] args) {

        String dir = System.getProperty("user.dir") + "/src/by/it/malyshev/jd01_14";
        String filename = "integer.dat";
        File f = new File(dir, filename);

        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                out.writeDouble((Math.random() * 50));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(f)))) {

            double sum = 0;
            double count = 0;
            while (in.available() > 0) {
                double d = in.readDouble();
                System.out.printf("%4.2f\n", d);
                sum += d;
                count++;
            }
            System.out.printf("Среднее арифметическое = %4.3f\n", sum / count);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
