package by.it.ali.jd01_05;

import com.sun.org.apache.xpath.internal.SourceTree;

import static java.lang.Math.*;

class TaskB {
    static void SolveB1() {
        System.out.println("TaskB1:");
        double sum = 0;
        for (int x = 1; x < 9; x = x + 1) {
            for (int i = 6; i < 12; i++) {
                double y = pow((x + 2), 1.3 * i);
                sum = sum + y;
            }
        }
        System.out.println(sum);
    }

    static void SolveB2() {
        double r = 0.491 * pow(10, 4);
        double z, y;
        System.out.println("TaskB2:");
        System.out.printf("%11s%11s", "Значение p", "Значение y");
        for (double p = -1; p <= 14; p = p + 1.5) {
            if ((p - 1) < 0) {
                z = 3.8 * sin(toRadians(p));
            } else if ((p - 1) >= 3) {
                z = pow((2 / (p + 1) + sin(PI / 6)), 5);
            } else {
                z = pow(p, 3) - p;
            }
            double k=abs(z - 1.4 * r);
            y = pow(4.67, k);
            System.out.printf("%11.3f%11.3f", p, y);
            System.out.println();
        }
    }
}
