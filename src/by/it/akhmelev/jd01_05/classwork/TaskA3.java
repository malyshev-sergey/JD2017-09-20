package by.it.akhmelev.jd01_05.classwork;

public class TaskA3 {
    static void sovleTaskA3(){
        double x=12.1;
        for (double a=-5;a<=12;a=a+3.75){
            double f=Math.exp(a*x)-3.45*a;
            System.out.printf("При a=%6.2f f=%10g\n",a,f);
        }
    }



}
