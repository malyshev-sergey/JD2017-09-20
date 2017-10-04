package by.it.Biazverkhi.jd01_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InOut {
//ввод строки с клавиатуры
    static String getOneLine() throws IOException {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        String line = stin.readLine();
        stin.close();
        return line;
    }

    // вывод массива
    static void printArray(int[] array, int cols) {

        for (int i = 0; i < array.length; i++) {
            if(i%cols==0)
                System.out.println("");
            System.out.printf("%s[%-2d]=%-4d ", "V", i, array[i]);


        }
    }




}





