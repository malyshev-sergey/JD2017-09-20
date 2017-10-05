package by.it.dubrova.jd01_03;

/*
*           class InOut
* Задача:  1. реализовать ввод строки с клавиатуры
*               static String inputFromKeyboard();
*          2. реализовать методы создания 1-2 мерных массивов
*               static double[] createArrayFromString(String s);
*               static double[][] create2DArrayFromString(String s, int row);
*
*           class Util
* Задача:  1. реализовать статик методы для поиска Min и Max значения в одномерном массиве типа double
*           static double getMaxValueFromArray(double[] d);
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InOutA {
    public static void main(String[] args) throws IOException {


        double[][] doubleArray = create2DArrayFromString("1 3 4 5 2 5 6 8", "1 2 4 5 6 7 8 9", "5 7 3 7 9 7 4 6");

        System.out.println("dddd");
    }




public static String inputFromKeyboard() throws IOException {
    BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
    return b.readLine();
}



public static double[] createArrayFromString(String s){
    String[] tmp = s.split(" ");
    double[] arr = new double[tmp.length];

    for(int i = 0; i < tmp.length; i++){
        arr[i] = Double.parseDouble(tmp[i]);
    }

    return arr;
}

public static double[][] create2DArrayFromString(String... s){
    int countRow = s.length; //длинна первой мерности

    double d[][] = new double[countRow][];

        //d[i][j]
    for (int i = 0; i < countRow; i++){  //тут заполняем 1 мерность

        double tmp[] = createArrayFromString(s[i]); //присвоили ссылку на массив
        int slen = tmp.length;
        for (int j = 0; j < slen; j++){// 2 мерность
            d[i] = new double[slen];  // создание новго элемента, пздц
            d[i][j] = tmp[j];
//System.out.print(" " + tmp[j]);
        }
//System.out.println();
    }

    return d;
}


}
