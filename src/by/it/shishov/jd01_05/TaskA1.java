package by.it.shishov.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Сергей on 02.10.2017.
 */
public class TaskA1 {
    static void solveTaskA1() {

            double a = 756.13;
            double x = 0.3;
            double p1 = cos((pow(x * x + PI / 6, 5)));
            double p2 = sqrt(x * pow(a, 3));
            double p3 = log(abs((a - 1.12 * x) / 4));
            double res = p1 - p2 - p3;
            System.out.println("TaskA1 result with parts = " + res);
            double res2 = cos((pow(x * x + PI / 6, 5))) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        System.out.println("TaskA1 result with one expression = " + res2);


    }
}
