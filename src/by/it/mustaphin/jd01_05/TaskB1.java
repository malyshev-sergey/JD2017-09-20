package by.it.mustaphin.jd01_05;

import static java.lang.Math.pow;

class TaskB1 {

    void solveTaskB1() {
        double y = 0.0;
        for (int x = 1; x <= 8; x++) {
            for (int i = 6; i <= 11; i++) {
                double yk = pow((x + 2), i * 1.3);
                y += yk;
                System.out.printf("x=%-2d y=%-2d yk=%-3.4f\n", x, i, yk);
            }
        }
        System.out.printf("y=%-4.5f", y);
    }

}
