package by.it.ali.jd01_05;
import java.util.Scanner;
import static java.lang.Math.*;
/**
 * Created by user on 02.10.2017.
 */
public class TaskA {
    static void SolveA1(){
        double a=756.13;
        double x=0.3;
        double p1=cos(pow((x*x+PI/6),5));
        double p2=pow(x*pow(a,3),1/2);
        double p3=log(abs((a-1.12*x)/4));
        double res=p1-p2-p3;
        double res2=cos(pow((x*x+PI/6),5))-pow(x*pow(a,3),1/2)-log(abs((a-1.12*x)/4));
        System.out.println("Несколькими частями "+res+" Одним выражением: "+res2);
    }

    static void SolveA2(){
        Scanner in=new Scanner(System.in);
        System.out.println("Введите а");
        double a = in.nextDouble();
        double b = 0.371;
        double y = tan(pow((a+b),2))-pow((a+1.5),1/3)+a*pow(b,5)-b/log(a*a);
        System.out.println("y="+y);
    }

    static void SolveA3(){
      double x=1.21;
        System.out.printf("%11s%11s","Значение a","Значение f");
        System.out.println();
      for (double a=-5; a<=12; a=a+3.75)
        {
        double f=exp(a*x)-3.45*a;
            System.out.printf("%11.2f%11g",a,f);
            System.out.println();
        }
    }


}
