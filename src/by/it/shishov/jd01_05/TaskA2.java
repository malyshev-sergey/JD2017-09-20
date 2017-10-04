package by.it.shishov.jd01_05;

import java.util.Scanner;
import static java.lang.Math.*;

/**
 * Created by Сергей on 02.10.2017.
 */
public class TaskA2 {
    static  void solveTaskA2(){
        double a = new Scanner(System.in).nextDouble();
        double b = 0.371;
        double res = tan(pow(a+b,2)) - cbrt(a+1.5) + a*pow(b,5) - b/log(a*a);
        System.out.println("Task A2 results = " + res);

    }
}
