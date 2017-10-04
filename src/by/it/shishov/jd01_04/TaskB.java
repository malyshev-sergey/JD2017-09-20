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
        System.out.println("Введите строку фамилий через пробел: ");
        surnames = new Scanner(System.in).nextLine().split(" ");
    }

    public static void getNumber() {

        System.out.println("Введите количество фамилий: ");
        number = Integer.parseInt(new Scanner(System.in).nextLine());
    }

    public static int[][] getSalary() {

        salaryArr = new int[4][number];
        int count = 0;
        for (int i = 0; i < surnames.length; i++) {
            System.out.println("Введите зарплаты за 4 квартала человека с фамилий " + surnames[i]);
            for (int j = 0; j < 4; j++) {
                salaryArr[count][j] = Integer.parseInt(new Scanner(System.in).nextLine().split(" ")[count]);
                count++;
            }

        }
        return salaryArr;
    }

    public static void printSalaryTable() {
        System.out.printf("%7s  %9s  %9s  %9s  %9s  %5s", "Фамилия", "1 квартал", "2 квартал", "3 квартал", "4 квартал", "Итого");
        for (int i = 0; i < number; i++) {
            System.out.printf("\n" + "%12s  %9s  %9s  %9s  %9s  %5s", surnames[i], salaryArr[0][i], salaryArr[1][i], salaryArr[2][i], salaryArr[3][i], salaryArr[0][i] + salaryArr[1][i] + salaryArr[2][i] + salaryArr[3][i]);
        }


    }
}
