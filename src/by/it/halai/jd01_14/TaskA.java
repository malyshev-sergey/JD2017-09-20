package by.it.halai.jd01_14;

import java.io.*;

/**
 * @author Vitaly Halai
 */
public class TaskA {
    public static void taskA() throws IOException {


        String src = System.getProperty("user.dir") + "/src/by/it/halai/";
        String filename = src + "jd01_14/integer.dat";
        File f = new File(filename);

        DataOutputStream dos = null;
        try

        {
            dos = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20 + 10));
            }
        } catch (
                FileNotFoundException e)

        {
            System.out.println("Файла нет: " + filename);
        } finally

        {
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
            int count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                sum = sum + i;
                count++;
                System.out.println(count + "-e Случайное число = " + i);
            }
            System.out.println("Среднеарифмитическое = " + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
