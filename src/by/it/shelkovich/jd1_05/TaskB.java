package by.it.shelkovich.jd1_05;


public class TaskB {
    static void Part4() {
        System.out.println("\nЧасть 4");
        double summ = 0;
        for (int x = 0; x <= 8; x++) {
            double y = 0;
            for (int i = 6; i <= 11; i++) {
                y += Math.pow(x + 2, 1.3 * i);
            }
            summ += y;
        }
        System.out.printf("Сумма всех сумм: %-5.3g\n", summ);
    }

    static void Part5() {
        System.out.println("\nЧасть 5");
        double r = 0.491E+4;

        for (double p = -1.9999; p < 15; p += 1.5) {
            double z = 0;
            if (p - 1 < 0) z = 3.8 * Math.sin(p);
            else if ((p - 1 >= 0) && (p - 1 < 3)) z = Math.pow(p, 3) - p;
            else if (p - 1 >= 3) z = Math.pow(2 / (p + 1) + Math.sin(Math.PI / 6), 5);


            double power = Math.abs(z - 1.4 * r);
            double y = Math.pow(4.67, power);
            if (y == Double.POSITIVE_INFINITY) System.out.printf("Параметр р равен %-3.5g, результат вычислений: 4.67 в степени %4.3f, иначе говоря - %-3.5g\n", p, power, y);
            else System.out.printf("Параметр р равен %-3.5g, результат вычислений: %-3.5g\n", p, y);
        }
    }
}
