package by.it.halai.jd01_02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Utils {
    //чтение одной строки
    static String getOneLine() throws IOException {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        return stin.readLine();
    }

    //преобразование одной строки в массив
    static int[] lineToIntArray(String line) {
        //деление строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
        //создаем и заполняем массив чисел
        int[] array = new int[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            array[j] = Integer.parseInt(strArray[j]);
        }
        return array;
    }

    //преобразование одной строки в  целое число
    static int lineToIntNumber(String str) {
        return Integer.parseInt(str);
    }

    //преобразование одной строки в  десятичное число
    static double lineToDoubleNumber(String str) {
        return Double.parseDouble(str);
    }
}
