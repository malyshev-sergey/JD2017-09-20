package by.it.Biazverkhi.jd01_05;
import static java.lang.Math.*;
class TaskA1 {
    static void solveTaskA1(){
    double a=756.13;
    double x=0.3;
    double p1=cos(Math.pow((x*x+PI/6),5));
        double p2 = sqrt(x * pow(x, a));
        double p3 = Math.log(abs((a - 1.12 * 4) / 4));
        double res = p1 - p2 - p3;
        System.out.printf("Результат с разбивкой выражения на части составляет: %10.5f", res);
        double res2 = cos(Math.pow((x * x + PI / 6), 5)) - sqrt(x * pow(x, a)) - Math.log(abs((a - 1.12 * 4) / 4));
        System.out.println(" ");
        System.out.printf("Результат с полным выражением составляет: %10.5f", res2);
        System.out.println(" ");
    }
}

