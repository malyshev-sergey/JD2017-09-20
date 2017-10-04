package by.it.Biazverkhi.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Utils {
    //чтение одной строки с консоли
    static String getOneLine() throws IOException {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        //stin.close();
        return stin.readLine();
    }

    //преобразование одной строки в массив чисел
    static int[] lineToIntArray(String line) {
        // деление строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
        //создаем и заполняем массив чисел
        int[] array = new int[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            array[j] = Integer.parseInt(strArray[j]);
        }
        return array;
    }


        //чтение значения с командной строки
        static String getOneInt() throws IOException {
            BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
            //stin.close();
            return stin.readLine();
        }




}