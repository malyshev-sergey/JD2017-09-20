package by.it.meshchenko.jd01_05;

import java.io.IOException;

public class Task2 {
    public static void main() throws IOException {
        System.out.println("\nTask2");
        System.out.print("введите a, b:");
        String line = Util.getOneLine();
        double[] arr = Util.lineToInDoubleArray(line);
        double a = arr[0];
        double b = arr[1];
        main(a, b, true);
    }

    public static void main(double a, double b, boolean key) throws IOException {
        if(!key)System.out.println("\nTask2");
        System.out.printf("y = tg(a+b)^2 - (a+1.5)^1/3 + a*b^5 - b/ln(a^2); a=%-7.3f, b=%-7.3f %n", a, b);
        double y = Math.tan(Math.pow((a+b),2)) - Math.pow((a+1.5),(1/3)) + a*Math.pow(b,5) - b/Math.log(Math.pow(a,2));
        System.out.printf("y = %-7.3f", y);
    }
}
