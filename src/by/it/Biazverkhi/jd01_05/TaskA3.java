package by.it.Biazverkhi.jd01_05;

import static java.lang.Math.exp;

class TaskA3 {
    static void solveTaskA3() {
        double x = 12.1;

        for (double a = -5; a <= 12; a += 3.75) {
            double function = exp(a * x) - 3.45 * a;
            System.out.printf("\t при a=%5.3g\ty=%5.3g\n", a, function);

        }


    }
}