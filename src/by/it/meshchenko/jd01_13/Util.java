package by.it.meshchenko.jd01_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    static String getOneLine() throws IOException {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        String line = stin.readLine();
        //stin.close();
        return line;
    }

    static double lineToDouble(String line){
        //дедение строки на элементы массива по пробелам
        String[] strArray = line.trim().split(" ");
        return Double.parseDouble(strArray[0]);
    }

    static void printException(Exception e){
        System.out.println("|e|="+e);
        System.out.println("|e.getMessage()|="          +e.getMessage());
        System.out.println("|e.getStackTrace.length|="  +e.getStackTrace().length);
        System.out.println("|e.getStackTrace|="         +e.getStackTrace());
        for (int j = 0; j < e.getStackTrace().length; j++) {
            System.out.println("|e.getStackTrace["+j+"]|="+e.getStackTrace()[j]);
        }
        System.out.println("|e.printStackTrace|");
        e.printStackTrace();
    }
}
