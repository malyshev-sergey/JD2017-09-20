package by.it.mustaphin.jd01_05;

import static java.lang.Math.*;

public class TaskA1 {

    void byParts() {
        double z = 0;
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow(pow(x, 2) + (PI / 6), 5));
        double part2 = (-1) * (sqrt(x * pow(a, 3)));
        double part3 = log((a - 1.12 * x) / 4);
        z = part1 + part2 + part3;
        System.out.println(z);
    }

    void byFull() {
        double a = 756.13;
        double x = 0.3;
        double z = cos(pow(pow(x, 2) + (PI / 6), 5)) - (sqrt(x * pow(a, 3))) + log((a - 1.12 * x) / 4);
        System.out.println(z);
    }

}
