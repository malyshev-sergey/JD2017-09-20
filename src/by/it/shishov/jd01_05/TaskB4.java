package by.it.shishov.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Сергей on 04.10.2017.
 */
public class TaskB4 {
    static void solveTaskB4() {
        double y = 0;
        for (double i = 6; i <= 11; i++) {
            for (double x = 1; x <= 8; x++) {
                y = y + pow((x + 2), ((1.3) * i));
            }
        }
        System.out.printf("TaskB4 result = %4.5g", y);
    }

    static void solveTaskB5() {
        double r = 0.491 * pow(10, 4);
        double z = 0, y = 0;
        for (double p = -2; p <= 15; p += 1.5) {
            if (p - 1 < 0) {
                z = 3.8 * sin(p);
            } else if ((p - 1) >= 0 && (p - 1) < 3) {
                z = pow(p, 3) - p;
            } else if ((p - 1) >= 3) {
                z = pow(2 / (p + 1) + sin(PI / 6), 5);
            }
            y = pow(4.67, abs(z - (1.4 * r)));
        }
        System.out.println("\nTaskB5 result = " + y);
    }
}
