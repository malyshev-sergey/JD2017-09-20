package by.it.shishov.jd01_13;

import java.util.Scanner;

/**
 * Created by Сергей on 28.10.2017.
 */
public class TaskA {
    static void countSquareRoots(){
        System.out.println("Вводите числа через ENTER. Введите END, чтобы закончить подсчет корней.");
        double counter = 0;
        String number = "";
        while (true) {
            try {
                number = new Scanner(System.in).nextLine();

                if (number.equals("END")) {
                    System.out.println("Сумма корней = " + counter);
                    break;
                }
                if (Double.parseDouble(number) < 0)
                    throw new ArithmeticException();
                counter += Math.sqrt((Double.parseDouble(number)));
                System.out.println("Сумма корней = " + counter);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ! Невозможно перевести в тип double.");
            }
            catch (ArithmeticException e){
                System.out.println("Ошибка! Невозможно взять квадратный корень числа " + number);
            }


        }
    }
}
