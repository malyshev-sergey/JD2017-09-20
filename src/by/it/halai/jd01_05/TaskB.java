package by.it.halai.jd01_05;


public class TaskB {

    static void solveTaskB1() {
        double y = 0;

        for (int x = 1; x <= 8; x = x + 1) {
            for (int i = 6; i <= 11; i++) {
                double yi = Math.pow(x + 2, 1.3 * i);
                y = y + yi;
            }
            System.out.printf("при х = %2d,  y = %7.2g\n", x, y);
        }
    }

    static void solveTaskB2() {
        double r = 0.491 * Math.pow(10, 4);
        double z;
        for (double p = -2; p < 15; p = p + 1.5) {
            if (p - 1 < 0) {
                z = 3.8 * Math.sin(p);
            } else if ((p - 1) >= 0 && (p - 1) < 3) {
                z = Math.pow(p, 3) - p;
            } else {
                z = Math.pow((2 / (p + 1) + Math.sin(Math.PI / 6)), 5);
            }
            double y = Math.pow(4.67, Math.abs(z - 1.4 * r));
            System.out.printf("при p = %7.2f   y = %g\n", p, y);
        }
    }
}
