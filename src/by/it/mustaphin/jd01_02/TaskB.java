package by.it.mustaphin.jd01_02;

import java.util.InputMismatchException;
import java.util.Scanner;

class TaskB {


    int[][] getMatrix(int numb) {
        int count = 0;
        int mas[][] = new int[numb][numb];
        for (int i = 0; i < numb; i++) {
            for (int k = 0; k < numb; k++) {
                mas[i][k] = ++count;
            }
        }
        return mas;
    }

    void printMatrix(int[][] mas) {
        for (int innerMas[] : mas) {
            for (int digit : innerMas) {
                System.out.printf("%- 4d", digit);
            }
            System.out.println();
        }
    }

    private void printMonth() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Необходимо ввести целочисленное значение от 1 до 12");
        try {
            int mounth = sc.nextInt();
            if (1 > mounth || 12 < mounth) {
                printMonth();
            }
            switch (mounth) {
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
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Введено не целочисленное значение");
            printMonth();
        }
    }

    void seekRoots(int[] args) {
        int a = args[0], b = args[1], c = args[2], d = (b * b) - (4 * a * c);
        System.out.println("D=" + d);
        if (0 < d) {
            int x1 = ((b * (-1) + (int) (Math.sqrt(d))) / (2 * a));
            int x2 = ((b * (-1) - (int) (Math.sqrt(d))) / (2 * a));
            System.out.printf("x1=%-2d x2=%-2d", x1, x2);
        } else if (0 == d) {
            int x = ((b * (-1) - (int) (Math.sqrt(d))) / (2 * a));
            System.out.printf("x1=%-2d", x);
        } else {
            System.out.println("Выражение не имеет решение");
        }
    }
}
