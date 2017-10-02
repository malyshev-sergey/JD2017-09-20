package by.it.akhmelev.jd01_05.classwork;

import java.util.Scanner;

import static java.lang.Math.*;

public class TaskA2 {

    static void solveTaskA2(){
        Scanner scanner=new Scanner(System.in);
        double a=scanner.nextDouble();
        double b=0.371;
        double res=tan(pow(a+b,2))-cbrt(a+1.5)+a*pow(b,5)-b/log(a*a);
        System.out.println("Task A2 result = "+res);
    }

}
