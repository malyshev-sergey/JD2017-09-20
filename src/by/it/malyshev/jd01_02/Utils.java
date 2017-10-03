package by.it.malyshev.jd01_02;

//import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

    /*
    static String getOneLine(){
    String line=new Scanner(System.in).nextLine();
    return line;
    }
    */
    //чтение одной строки с консоли
    static String getOneLine() throws IOException {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        String line = stin.readLine();
//        stin.close();
        return line;
    }

    //преобразование одной строки в массив чисел
    static int[] lineToIntArray(String line) {
        String[] strArray = line.split(" ");
        int[] array = new int[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            array[j] = Integer.parseInt(strArray[j]);
        }
        return array;
    }

    static double[] lineToDoubleArray(String line) {
        String[] strArray = line.split(" ");
        double[] arrayDouble = new double[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            arrayDouble[j] = Double.parseDouble(strArray[j]);
        }
        return arrayDouble;
    }
}
