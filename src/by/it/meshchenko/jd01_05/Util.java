package by.it.meshchenko.jd01_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    static String getOneLine() throws IOException {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        String line = stin.readLine();
        //stin.close();
        return line;
    }

    //Преобразование строки в массив
    static double[] lineToInDoubleArray(String line){
        //дедение строки на элементы массива по пробелам
        String[] strArray = line.trim().split(" ");
        //создаём и заполняем массив чисел
        double[] array = new double[strArray.length];
        for(int i = 0; i < strArray.length; i++){
            array[i] = Double.parseDouble(strArray[i]);
        }
        return array;
    }
}
