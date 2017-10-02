package by.it.ali.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void People() {
        Scanner in = new Scanner(System.in);
        System.out.println("Фамилии сотрудников?");
        String fam = in.nextLine();
        String[] famMas = fam.split(" ");
        int[][] kol = new int[famMas.length][5];
        int sum = 0;
        for (int i = 0; i < famMas.length; i++) {
            System.out.println("Каков доход сотрудника " + famMas[i] + " за 4 квартала?");
            for (int j = 0; j < 4; j++) {
                kol[i][j] = in.nextInt();
                kol[i][4] = kol[i][j] + kol[i][4];
            }
            sum = kol[i][4] + sum;
        }
        System.out.printf("%-13s%-11s%-11s%-11s%-11s%-11s", "Фамилия", "Квартал 1", "Квартал 2", "Квартал 3", "Квартал 4", "Общий доход");
        System.out.println();
        for (int i = 0; i < famMas.length; i++) {
            System.out.printf("%-13s", famMas[i]);
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-11d", kol[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Общая сумма выплат: " + sum);
    }
}
