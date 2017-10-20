package by.it.mustaphin.jd01_13;

import java.util.Scanner;

public class TaskA {

    double sum = 0.0;

    void read() {
        Scanner sc = new Scanner(System.in);
        String line;
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
            read();

        } catch (NumberFormatException e) {
            System.err.println("Допускаются только натуральные числа");
            read();
        } finally {
            if (null != sc) {
                sc.close();
            }
        }
    }

}
