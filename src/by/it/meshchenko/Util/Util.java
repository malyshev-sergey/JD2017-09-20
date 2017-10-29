package by.it.meshchenko.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Util {
    // Поиск элемента в массиве Number[]
    public static <T extends Number> boolean findInArray(T[] arr, T t){
        boolean res = false;
        if(arr.length > 0){
            for(int i = 0; i < arr.length; i++) {
                if(t == arr[i]) return true;
            }
        }
        return  res;
    }

    // Поиск элемента в массиве String[]
    public static <T extends String> boolean findInArray(T[] arr, T t){
        boolean res = false;
        if(arr.length > 0){
            for(int i = 0; i < arr.length; i++) {
                if(t.compareTo(arr[i]) == 0) return true;
            }
        }
        return  res;
    }

    // Поиск элемента в массиве Character[]
    public static <T extends Character> boolean findInArray(T[] arr, T t){
        boolean res = false;
        if(arr.length > 0){
            for(int i = 0; i < arr.length; i++) {
                if(t.compareTo(arr[i]) == 0) return true;
            }
        }
        return  res;
    }

    // Случайное число int между start и end
    public static int randomInt(int start, int end) {
        int random = new Random().nextInt(end-start);
        return start + random;
    }

    // Приведение строки к заданной длине, с заменой:
    // str = '12', привести к длине 5 символов, пустые заменить на '*'
    // str = '***12'
    public static String strDefiniteSize(String str, int size, String strReplace){
        StringBuilder res = new StringBuilder("");
        int len = str.length();
        if(size >= len) {
            for(int i = 0; i < (size - len); i++) {
                res.append(strReplace);
            }
            res.append(str);
        }
        else res.append(str.substring(0, size));
        return  res.toString();
    }

    // Прочитать строку с консоли
    public static String getOneLine() throws IOException {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        String line = stin.readLine();
        //stin.close();
        return line;
    }
}
