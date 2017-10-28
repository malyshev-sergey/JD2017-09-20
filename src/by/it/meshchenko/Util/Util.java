package by.it.meshchenko.Util;

import java.util.Random;

public class Util {
    public static <T extends Number> boolean findInArray(T[] arr, T t){
        boolean res = false;
        if(arr.length > 0){
            for(int i = 0; i < arr.length; i++) {
                if(t == arr[i]) return true;
            }
        }
        return  res;
    }

    public static <T extends String> boolean findInArray(T[] arr, T t){
        boolean res = false;
        if(arr.length > 0){
            for(int i = 0; i < arr.length; i++) {
                if(t.compareTo(arr[i]) == 0) return true;
            }
        }
        return  res;
    }

    public static <T extends Character> boolean findInArray(T[] arr, T t){
        boolean res = false;
        if(arr.length > 0){
            for(int i = 0; i < arr.length; i++) {
                if(t.compareTo(arr[i]) == 0) return true;
            }
        }
        return  res;
    }

    public static int randomInt(int start, int end) {
        int random = new Random().nextInt(end-start);
        return start + random;
    }

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
}
