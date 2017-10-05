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

public class InOutA {
    public static void main(String[] args) throws IOException { // везде ли нужно указывать throws и зачем и что это?

        System.out.println("jd01_03 постарался сделать аккуратно, с соблюдением правил написания кода");
        System.out.print("Введи строку с клавиатуры - double через пробел, и я создам из неё массив:");
        String s = inputFromKeyboard();
        System.out.println("\r\nВведена строка: " + s);
        System.out.println("Метод createArrayFromString создал из неё одномерный массив! Вот элемент с индексом 0: " + createArrayFromString(s)[0]);
        System.out.print("\r\nА сейчас создадим двумерный! Введите массив добл через пробел для первой мерности:");
        String mer1 = inputFromKeyboard();
        System.out.print("\r\nВведите массив добл через пробел для второй мерности:");
        String mer2 = inputFromKeyboard();
        System.out.println("\r\nЭлемент [0][0] вот:" + create2DArrayFromString(mer1,mer2)[0][0]);
        System.out.println("А вот Макс и Мин значения с первого введенного массива: "
                + Util.getMinValueFromArray(createArrayFromString(s)) + " и " + Util.getMaxValueFromArray(createArrayFromString(s)));
    }




private static String inputFromKeyboard() throws IOException {
    BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
    return b.readLine();
}



private static double[] createArrayFromString(String s){
    String[] tmp = s.split(" ");
    double[] arr = new double[tmp.length];

    for(int i = 0; i < tmp.length; i++){
        arr[i] = Double.parseDouble(tmp[i]);
    }

    return arr;
}

private static double[][] create2DArrayFromString(String... s){
    int countRow = s.length; //длинна первой мерности

    double d[][] = new double[countRow][];

        //d[i][j]
    for (int i = 0; i < countRow; i++){  //тут заполняем 1 мерность

        //double tmp[] = createArrayFromString(s[i]); //присвоили ссылку на массив
        double tmp[] = createArrayFromString(s[i]).clone(); // методом клон
        int slen = tmp.length;
        d[i] = new double[slen]; // создание новго элемента, пздц

        d[i] = tmp.clone();// этот метод можно использовать в обход циклов! И варнинги не вылазят

        //for (int j = 0; j < slen; j++){// 2 мерность
        //    d[i][j] = tmp[j];
//System.out.print(" " + d[i][j]);
        //}
//System.out.println();
    }
// правильно ли происходит присвоение ссылки на двумерный массив???
    return d;
}


}
