package by.it.dubrova.jd01_02;
/*
*
* homework type A
* WARNING: Очень грязный код
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    public static void main(String[] args) throws IOException {
    //    System.out.print("Введите массив чисел через пробел: ");
    //    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    String line =  br.readLine();

        String line = "5 5 12 4565 33 75 12 1 4 -4 3"; // Это введенные символы, если убрать закоментированный выше код
     // создали массив
        String[] arrayS = line.split(" ");

     // создаем массив с нужным размером
        int[] arrayI = new int[arrayS.length];
        int count = 0;
     // заполняем массив (возможно лучше простым for)
        for(String s : arrayS){
            arrayI[count] = Integer.parseInt(s);
            count++;
        }

     //основное тело================

        System.out.println("Max len val: " + getMaxLen(arrayI));
        System.out.println("Min len val: " + getMinLen(arrayI));
        System.out.println("Меньше средне-арифметического: " + srMin(arrayI));

        String uniq = "Уникальные цифры в числе: ";
        for (int i : arrayI){
            if (uniqueDigits(i)) uniq = uniq.concat(Integer.toString(i) + " ");
        }
        System.out.println(uniq);
    //==============================

    }

    public static String getMaxLen(int[] arr){
        // первый символ с чем сравнивать
        String res = Integer.toString(arr[0]);

        for (int i : arr){
            if (res.length() < Integer.toString(i).length())
                res = Integer.toString(i);
        }

        //System.out.print(res);
        return res;
    }



    public static String getMinLen(int[] arr){
        // первый символ с чем сравнивать
        String res = Integer.toString(arr[0]);

        for (int i : arr){
            if (res.length() > Integer.toString(i).length())
                res = Integer.toString(i);
        }
        //System.out.print(res);
        return res;
    }


 //выод строки чисел, значение которых меньше среднего арифметического
    public static String srMin(int[] arr){
        int sum = 0;
        String res = "";
        for (int i : arr){
            sum += i;
        }
        sum /= arr.length;
        // средне-арифметические аргументов  массива
        //System.out.print(sum);

        for (int i : arr){
            if (i < sum)
                res = res.concat(Integer.toString(i)) + " ";
        }

        return res;
    }

// проверить на уникальность чисел
    public static boolean uniqueDigits(Integer digit){  // немного подсмотрел - непонятный тип Integer
        //длинна числа
        int len = Integer.toString(digit).length();
        // разбить на массив char
        char ch[] = digit.toString().toCharArray();


        for (int i = 0; i <= len; i++){
            for (int j = i+1; j < ch.length; j++)
                if (ch[i] == ch[j]) return false;
        }


        return true;
    }
}
