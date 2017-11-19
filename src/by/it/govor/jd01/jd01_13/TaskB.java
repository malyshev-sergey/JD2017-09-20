package by.it.govor.jd01.jd01_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TaskB {
    public static void main(String[] args) throws Exception {
        try {
            TaskB.level1();
        } catch (NumberFormatException e){
            System.out.println("Ошибка 1 уровня :"+e);}
        try {
            TaskB.level2();
        } catch (IOException e){
            System.out.println("Ошибка 2 уровня :"+e);}

            TaskB.level3();
        try {
            String[] s = new String[5];
            s[6] = "Привет";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка 0 уровня: " + e);


        }

    }
    public static void level1() throws Exception{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(r.readLine());
    }
    public static void level2()throws IOException{
            int i =-1;
        double c =Math.sqrt(i);
    }
    public static void level3(){
        int a =5;
        int b= 0;
        try {
            int c =a/b;
        }catch (ArithmeticException e){
            System.out.println("Ошибка 3 уровня: "+e);}
    }
}
