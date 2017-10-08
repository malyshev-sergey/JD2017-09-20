package by.it.dubrova.jd01_05;


import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        /***** Первое задание *****/
        double a = 756.13;
        double x = 0.3;
        System.out.println(myFormula1(a,x));
        System.out.println(myFormula2(a,x));

        /***** Второе задание *****/
        a = 1.21;
        double b = 0.371;
        System.out.println(myFormula3(a,b));
    }


    public static double myFormula3(double a, double b){
        double z = tan(pow((a + b),2)) - /*это куб корень*/pow(a + 1.5, 1/3) - a*pow(b,5) - b/(log(a*a));
        return z;
    }


    public static double myFormula1(double a, double x){
        double z = 0;
        // сразу кос а потом пов или наоборот???
        z = cos(pow( pow(x,2) + PI / 6,5)) - sqrt(pow(x*a,3)) - log(abs( (a - 1.12*x)/4 ));
        //z = pow(cos( pow(x,2) + PI / 6),5) - sqrt(pow(x*a,3)) - log(abs( (a - 1.12*x)/4 ));
        //System.out.println(z);
        return z;
    }


    public static double myFormula2(double a, double x){
        double A,B,C,Z;
        A = cos(pow( pow(x,2) + PI / 6,5));
        B = sqrt(pow(x*a,3));
        C = log(abs( (a - 1.12*x)/4 ));
        Z = A - B - C;
        return Z;
    }

}




