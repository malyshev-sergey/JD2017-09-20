package by.it.ali.jd01_02;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadStr {
    static String GetLine() throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String rLine = br.readLine();
        return rLine;
    }
    static int[] lineToIntArray(String str){
        String[] strA = str.split(" ");
        int[] a = new int[strA.length];
        for(int j=0; j<strA.length; j++)
        {
         a[j]=Integer.parseInt(strA[j]);
        }
        return a;
    }
}
