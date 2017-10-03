package by.it.malyshev.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    static void functionFour(double start, double finish, double step) {

        double sumY = 0;
        double mulY = 1;
        for (double x = start; x <= finish; x += step) {
            for (int i = 1; i <= 11; i++) {
                sumY += pow(x + 2, 1.3 * i);
                mulY *= pow(x + 2, 1.3 * i);
            }
            System.out.printf("Сумма y = %3.2e   Произведение y = %3.2e\n", sumY, mulY);
        }
    }

    static void functionFive(double start, double finish, double step, double r) {

        double z = 0;
        for (double p = start + step; p < finish; p += step) {
            if ((p - 1) < 0) {
                z = 3.8 * sin(p);
            } else if ((p - 1) >= 0 && (p - 1) < 3) {
                z = pow(p, 3) - p;
            } else if ((p - 1) >= 3) {
                z = pow(2 / (p + 1) + sin(PI / 6), 5);
            }
            double y = pow(4.67, abs(z - 1.4 * r));
            System.out.printf("y = %3.2e  при p-1 = %3.1f\n", y, (p - 1));
        }
    }

}
