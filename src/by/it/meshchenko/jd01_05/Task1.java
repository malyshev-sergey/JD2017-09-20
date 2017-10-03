package by.it.meshchenko.jd01_05;

import java.io.IOException;

public class Task1 {
    public static void main(double a, double x) throws IOException {
        partialExample(a,x);
        fullExample(a,x);
    }

    private static void partialExample(double a, double x){
        System.out.printf("Task1%npartialExample a=%-7.3f  x=%-7.3f: %n", a, x);
        System.out.printf("z = z1 - z2 -z3 %n");
        System.out.printf("z1 = cos(x^2 + pi/6)^5; %n");
        System.out.printf("z2 = sqrt(x*a^3); %n");
        System.out.printf("z3 = ln|((a-1.12x)/4); %n");
        double z1 = Math.cos(Math.pow((Math.pow(x,2) + Math.PI/6),5));
        double z2 = Math.sqrt(x*Math.pow(a,3));
        double z3 = Math.log(Math.abs((a-1.12*x)/4));
        double z = z1 - z2 - z3;
        System.out.printf("z1 = %-7.3f  z2 = %-7.3f  z3 = %-7.3f %n", z1, z2, z3);
        System.out.printf("z = %-7.3f %n", z);
    }

    private static void fullExample(double a, double x){
        System.out.printf("Task1%nfullExample a=%-7.3f  x=%-7.3f: %n", a, x);
        System.out.printf("z =  cos(x^2 + pi/6)^5 - sqrt(x*a^3) - ln|((a-1.12x)/4)%n");
        double z = Math.cos(Math.pow((Math.pow(x,2) + Math.PI/6),5)) - Math.sqrt(x*Math.pow(a,3)) - Math.log(Math.abs((a-1.12*x)/4));
        System.out.printf("z = %-7.3f", z);

    }


}
