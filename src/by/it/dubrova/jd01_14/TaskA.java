package by.it.dubrova.jd01_14;

import java.io.*;
import java.util.*;

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
///////////////////////////////////////////////////////////////////////////////////////////////////
    public static void readIntsFromFile(String filename) throws IOException {
        filename = System.getProperty("user.dir") + "/../../"+filename;
        DataInputStream fis = null;
        List<Integer> ints = new ArrayList<>();

        try{
        fis = new DataInputStream(new FileInputStream(new File(filename)));
            do {
                ints.add(fis.readInt());
            } while (fis.available() != 0);
        }
        catch (FileNotFoundException fnf){
            System.out.println("File Not Found!");
        }
        finally {
            try{
                fis.close();
            }
            catch (FileNotFoundException fnf){
                System.out.println("Не получается закрыть файл");
            }
        }

        System.out.println("Ints из файла: " + ints);
        int tmp = 0;
        for (int i = 0; i < 20; i++){
            tmp += ints.get(i);
        }
        System.out.println("Среднее арифметическое: " + tmp / 20);

    }

    public static void main(String[] args) throws IOException {
        writeIntsToFile("testtt1.txt");
        readIntsFromFile("testtt1.txt");

    }

}

