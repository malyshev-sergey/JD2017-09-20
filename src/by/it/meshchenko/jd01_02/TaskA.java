package by.it.meshchenko.jd01_02;

public class TaskA {
    //метод поиска самого длинного элемента и его длины
    //резуотат - строка для вывода на экран
    static String getMax(int array[]){
        Integer res = array[0];
        for(Integer i: array){
            if(res.toString().length() < i.toString().length()){
                res = i;
            }
        }
        return "MAX = " + res.toString() + "  length = " + res.toString().length();
    }

    //метод поиска самого короткого элемента и его длины
    //резуотат - строка для вывода на экран
    static String getMin(int array[]){
        Integer res = array[0];
        for(Integer i: array){
            if(res.toString().length() > i.toString().length()){
                res = i;
            }
        }
        return "MIN = " + res.toString() + "  length = " + res.toString().length();
    }

    //Длина меньше(больше) средней
    static double mean(int[] arr){
        double res = 0;
        for(int i: arr) res = res + i;
        res = res / arr.length;
        return res;
    }

    //метод поиска числа состоящего из разных чисел
    static boolean uniqueDigits(Integer value){
        char ch[] = value.toString().toCharArray();
        for(int i = 0; i < ch.length-1; i++){
            for(int j = i + 1; j < ch.length; j++){
                if(ch[i] == ch[j]) return false;
            }
        }
        return true;
    }
}
