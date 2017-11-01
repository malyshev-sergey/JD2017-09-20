package by.it.ali.jd01_14;

import java.io.*;

public class TaskA {
    public static void main(String[] args) throws IOException {
        // static void WriteInt() throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/ali/";
        String numbers = src + "jd01_14/integer.dat";
        File f = new File(numbers);
        DataOutputStream d = null;
        try {
            d = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                d.writeInt((int) (Math.random()*20+5));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл отсутствует" + numbers);
        } finally {
            if (d != null) {
                d.close();
            }
        }

        //  static void ReadInt(String numbers) throws IOException{
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(numbers)))) {
            double sum = 0;
            double count = 0;
            int i;
            while (in.available() > 0) {
                i = in.readInt();
                System.out.print(i+" ");
                sum = sum + i;
                count++;
            }
            System.out.println("Среднее арифметическое:"+sum/count);
        }
    }
}


