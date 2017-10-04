package by.it.uuu.jd01_05;

import java.util.Scanner;

import static java.lang.Math.log;
import static java.lang.Math.pow;


class TaskA2 {
    static void solveTaskA2ver1() {
        double a = 1.21;
        double b = 0.371;
        double y = Math.tan(pow((a + b), 2) - pow((a + 1.5), -3) + a * pow(b, 5) - b / log(pow(a, 2)));
        System.out.printf("Версия 1.Значение функции y при a=%3.2f и b=%4.3f составляет %7.5f", a, b, y);
    }

    static void solveTaskA2ver2() {
        System.out.println("Введите значение аргументов функции через ввод (по умолчанию а=1,21), обратите внимание на разделитель");
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        System.out.println("Введите значение аргументов функции через ввод (по умолчанию b=0,371), обратите внимание на разделитель");
        double b = sc.nextDouble();
        double y = Math.tan(pow((a + b), 2) - pow((a + 1.5), -3) + a * pow(b, 5) - b / log(pow(a, 2)));
        System.out.printf("Версия 2.Значение функции y при a=%3.2f и b=%4.3f составляет %7.5f", a, b, y);

    }
}
