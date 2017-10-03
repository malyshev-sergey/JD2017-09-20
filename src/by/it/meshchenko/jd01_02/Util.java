package by.it.meshchenko.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    static String getOneLine() throws IOException{
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        String line = stin.readLine();
        stin.close();
        return line;
    }

    static int[] lineToInArray(String line){
        //дедение строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
        //создаём и заполняем массив чисел
        int[] array = new int[strArray.length];
        for(int i = 0; i < strArray.length; i++){
            array[i] = Integer.parseInt(strArray[i]);
        }
        return array;
    }
}
