package by.it.ali.jd01_13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskB {

    static void Numbers() throws NumberFormatException,ArithmeticException, InputMismatchException {
        System.out.println("Введите 3 не отрицательных числа числа");
   Scanner sc = new Scanner(System.in);
    Integer a = sc.nextInt();
    Integer b = sc.nextInt();
     Integer c = sc.nextInt();

 //   static void Sqrts() throws ArithmeticException{
        if (a < 0 || b < 0 || c < 0) {
            throw new ArithmeticException();
        }
        double d = Math.sqrt(a)+Math.sqrt(b)+Math.sqrt(c);
        System.out.println("Сумма корней введённых чисел: "+d);


//    static void DivZero(){
        try {
            System.out.println("Найдём остаток от деления на: ");
            int g = sc.nextInt();
            int da=a/g;
            int db=b/g;
            int dc=c/g;
            System.out.println("Остаток от деления на "+g+" для a: "+da+"для b: "+db+"для с: "+dc);
        }
        catch(ArithmeticException e){
            System.err.println("Деление на ноль! "+e);
        }
    }
}
