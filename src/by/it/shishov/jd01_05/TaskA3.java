package by.it.shishov.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Сергей on 02.10.2017.
 */
public class TaskA3 {
    static void solveTask3(){
        double x = 12.1;
        for (double a = -5; a <= 12; a+=3.75) {
            double f = exp(a*x) - 3.45*a;
            System.out.printf("При a =%6.2f f =%10g \n", a, f);
        }

    }
}
