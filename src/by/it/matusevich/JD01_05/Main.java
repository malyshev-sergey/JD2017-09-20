package by.it.matusevich.JD01_05;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.sin;


public class Main {
    public static void main(String[] args) {
        double res = 0;
        for (double i = 6; i <= 11; i++) {
            for (double x = 1; x <= 8; x++) {
                res = res + pow((x + 2), ((1.3) * i));
            }
        }
        System.out.printf("Result = %4.5g", res);
        double rad = 0.491 * pow(10, 4);
        double z = 0, y = 0;
        for (double p = -2; p <= 15; p += 1.5) {
            if (p - 1 < 0) {
                z = 3.8 * sin(p);
            } else if ((p - 1) >= 0 && (p - 1) < 3) {
                z = pow(p, 3) - p;
            } else if ((p - 1) >= 3) {
                z = pow(2 / (p + 1) + sin(PI / 6), 5);
            }
            y = pow(4.67, abs(z - (1.4 * rad)));
        }
        System.out.println("\nResult = " + y);
    }



}
