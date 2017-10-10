package by.it.mustaphin.jd01_05;

import static java.lang.Math.*;

public class TaskA3 {

    void tabFunc() {
        double x = 12.1;
        for (double a = -5; a <= 12; a += 3.75) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("%g => %g\n",a,f);
        }
    }

}
