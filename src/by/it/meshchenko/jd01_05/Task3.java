package by.it.meshchenko.jd01_05;

public class Task3 {
    public static void calculate(double x, double min, double max, double step){
        System.out.println("\nTask3");
        double a = min;
        System.out.println("f = Math.pow(Math.E,(a*x)) - 3.45*a");
        for (int i = 0; i <= (max - min)/step; i++){
            double f = f(x, a);
            System.out.printf("i=%-3d  a=%5.3f  f=%-9.3f %n", i, a, f);
            a = a + step;
        }
        System.out.println();
    }

    private static double f(double x, double a){
        return Math.pow(Math.E,(a*x)) - 3.45*a;
    }
}
