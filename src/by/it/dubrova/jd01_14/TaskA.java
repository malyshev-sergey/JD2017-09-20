package by.it.dubrova.jd01_14;

import java.io.*;

public class TaskA {

    public static void writeIntsToFile(String filename){
        filename = System.getProperty("user.dir") + "/../../"+filename;

        DataOutputStream fos =null;
        try {
            fos = new DataOutputStream(new FileOutputStream(new File(filename)));
            System.out.println("Запишем 20 интов...");
            for (int i = 0; i < 20; i++){
                fos.writeInt((int)(Math.random()*10)); // запсиываем инты
            }


        } catch (Exception exc)
        {
            System.out.println("Какая-то ошибка во время работы с файлом: " + exc);
        }
        finally {
            System.out.println("Записали. Теперь закроем файл...");
            try {
                fos.close();
            }
            catch (Exception exc){
                System.out.println("Кака-то ошибка закрытия файла!: " + exc);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        writeIntsToFile("testtt1.txt");


    }

}

