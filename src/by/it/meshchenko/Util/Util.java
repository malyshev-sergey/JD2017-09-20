package by.it.meshchenko.Util;

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
}
