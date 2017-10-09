package by.it.meshchenko.jd01_05;

public class Task4 {
    // 1<=x<=8, delta x = 1, i=6..11
    public static void calculate(double minX, double maxX, double stepX, double[] i){
        System.out.println("\nTask4");
        double summF = 0;
        double y = 0;
        double x = minX;
        System.out.println("f = SUMM ( SUMM(Math.pow(x+2,1.3*i) ) )  1<=x<=8  i=6..11 ");
        while (x <= maxX){
            for (int j = 0; j < i.length; j++){
                y = y + y(x, i[j]);
            }
            System.out.printf("x=%-3f  y=%-9.3f %n", x, y);
            summF = summF + y;
            x = x + stepX;
            y = 0;
        }
        System.out.printf("y=%-9.3f %n", summF);
        System.out.println();
    }

    private static double y(double x, double i){
        return Math.pow(x+2,1.3*i);
    }
}
