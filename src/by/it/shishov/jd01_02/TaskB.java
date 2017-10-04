package by.it.shishov.jd01_02;

import static java.lang.Math.*;

/**
 * Created by Сергей on 02.10.2017.
 */
public class TaskB {
    public static void printArr(int k) {
        int col = 0;
        for (int i = 1; i <= k; i++) {
            System.out.printf("[arr%-2d] = %-9d", i, i);
            col++;
            if ((col % Math.round(Math.sqrt(k)) == 0)) {
                System.out.println();
            }

        }
    }

    public static void quadraticEquation(double a, double b, double c) {
        double d, root1, root2;
        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");
        d = pow(b, 2) - 4 * a * c;
        System.out.println("D = " + d);
        if (d > 0) {
            root1 = (-b + sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
            root2 = (-b - sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
            System.out.println("Первый корень = " + root1 + "\n" + "Второй корень = " + root2);
        }
        else if (d == 0){
            root1 = (-b )/ (2*a);
            System.out.println("Корень = " + root1);
        }
        else{
            System.out.println("Нет корней");
        }
    }
}
