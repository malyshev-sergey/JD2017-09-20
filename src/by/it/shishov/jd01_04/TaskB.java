package by.it.shishov.jd01_04;

import java.util.Scanner;

/**
 * Created by Сергей on 29.09.2017.
 */
public class TaskB {
    private static int number;
    private static String[] surnames;
    private static int[][] salaryArr;

    public static void getSurnames() {
        System.out.println("Введите количество Фамилий: ");
        number = new Scanner(System.in).nextInt();
        System.out.println("Введите строку фамилий через пробел: ");
        surnames = new Scanner(System.in).nextLine().split(" ");
    }


    public static void getSalary() {
        salaryArr = new int[number][4];
        for (int i = 0; i < number; i++) {
            System.out.println("Введите зарплаты за 4 квартала человека с фамилией " + surnames[i]);
            String personSalary = new Scanner(System.in).nextLine();
            for (int j = 0; j < 4; j++) {
                salaryArr[i][j] = Integer.parseInt(personSalary.split(" ")[j]);
            }

        }
    }

    public static void printSalaryTable() {
        System.out.printf("%12s  %9s  %9s  %9s  %9s  %5s", "Фамилия", "1 квартал", "2 квартал", "3 квартал", "4 квартал", "Итого\n ");
        System.out.printf("%5s", "-");
        int summ = 0;
        for (int i = 0; i < 60; i++) {
            System.out.printf("%1s","-");
        }
        for (int i = 0; i < number; i++) {
            summ += (salaryArr[i][0] + salaryArr[i][1] + salaryArr[i][2] + salaryArr[i][3]);
            System.out.printf("\n%12s  %9d  %9d  %9d  %9d  %5d ", surnames[i], salaryArr[i][0], salaryArr[i][1], salaryArr[i][2], salaryArr[i][3], salaryArr[i][0] + salaryArr[i][1] + salaryArr[i][2] + salaryArr[i][3]);
        }
        System.out.printf("\n%5s", "-");
        for (int i = 0; i < 60; i++) {
            System.out.printf("%1s","-");
        }
        System.out.printf("\n%29s %3d","Итоговая сумма зарплат =", summ);

    }
}
