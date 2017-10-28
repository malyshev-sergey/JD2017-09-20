package by.it.ali.jd01_13;

import java.util.InputMismatchException;

public class Runner {
    public static void main(String[] args) {
        try{
        TaskA.SolveTaskA();
        TaskB.levelOne();

        }
        catch(NumberFormatException | InputMismatchException e){
            System.err.println("Неверно введено число!    "+e);
        } catch(ArithmeticException e){
            System.err.println("Введено отрицательное число! "+e);
        }
    }
}
