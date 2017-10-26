package by.it.likhanau.jd01_14;

import java.io.*;


public class TaskA {


    public static void writeReadTheDataAndPrintTheAverage() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("d://1.txt")))
        ) {
            for (int i = 0; i < 2; i++) {
                dataOutputStream.writeInt((int) (Math.random() * 10));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTheDataAndPrintItWithAverage() {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("d://1.txt")))) {
            int b;
            int sum = 0;
            int quantity = 0;
            while (dataInputStream.available() > 0) {
                b = dataInputStream.readInt();
                System.out.print(b + " ");
                sum += b;
                quantity++;
            }
            System.out.println("\nThe average is: " + (sum / quantity) + ".");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
