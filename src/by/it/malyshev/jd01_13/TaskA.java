package by.it.malyshev.jd01_13;

import java.util.Scanner;

/**
 * @author Sergey Malyshev
 */

public class TaskA {

    public static void main(String[] args) {
        double sum = 0.0;
        read(sum);

    }


    private static void read(double sum) {
        Scanner sc = new Scanner(System.in);
        String line;
        System.out.println("Введите натуральное число или end, чтобы выйти");
        try {
            while (true) {
                line = sc.nextLine();
                if (line.equalsIgnoreCase("end")) {
                    break;
                }
                double numb = Double.parseDouble(line);
                if (0 > numb) {
                    throw new ArithmeticException(String.valueOf(numb));
                }
                sum += Math.sqrt(numb);
                System.out.println("total " + sum);
            }
        } catch (ArithmeticException e) {
            System.err.println("Невозможно вычислть квадратный корень из " + e.getMessage());
            read(sum);

        } catch (NumberFormatException e) {
            System.err.println("Допускаются только натуральные числа");
            read(sum);
        } finally {
            if (null != sc) {
                sc.close();
            }
        }
    }


}
