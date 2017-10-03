package by.it.malyshev.jd01_02;

public class TaskB {

    static void matrix(int n) {
        int cols = (int) Math.sqrt(n);
        for (int i = 1; i <= Math.pow(cols, 2); i++) {
            System.out.printf("%4d", i);
            if (i % cols == 0) {
                System.out.println();
            }
        }
    }

    static void rootsOfQuadraticEquation(double array[]) {
        double d = array[1] * array[1] - 4 * array[0] * array[2];
        if (d > 0) {
            double x1 = (-1 * array[1] + Math.sqrt(d)) / (2 * array[0]);
            double x2 = (-1 * array[1] - Math.sqrt(d)) / (2 * array[0]);
            System.out.println("Квадратное уравнение имеет два корня:");
            System.out.printf("x1 = %6.2f, x2=%6.2f", x1, x2);
        } else if (d < 0) {
            System.out.println("Квадратное уравнение не имеет корней");
        } else {
            System.out.println("Квадратное уравнение имеет один корень:");
            double x = (-1 * array[1] + Math.sqrt(d)) / (2 * array[0]);
            System.out.printf("x = %6.2f", x);
        }
    }

    static void NumberToMonth(int n) {
        switch (n) {
            case 1:
                System.out.println("Январь");
                break;
            case 2:
                System.out.println("Февраль");
                break;
            case 3:
                System.out.println("Март");
                break;
            case 4:
                System.out.println("Апрель");
                break;
            case 5:
                System.out.println("Май");
                break;
            case 6:
                System.out.println("Июнь");
                break;
            case 7:
                System.out.println("Июль");
                break;
            case 8:
                System.out.println("Август");
                break;
            case 9:
                System.out.println("Сентябрь");
                break;
            case 10:
                System.out.println("Октябрь");
                break;
            case 11:
                System.out.println("Ноябрь");
                break;
            case 12:
                System.out.println("Декабрь");
                break;
            default:
                System.out.println("Нет такого месяца");
        }
    }
}
