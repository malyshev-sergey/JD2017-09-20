package by.it.mustaphin.jd01_04;

import java.util.Scanner;

class TaskB {

    String lastNames[] = {"Иванов", "Петров", "Сидоров"};
    int salary[][] = {{100, 150, 125, 201}, {150, 200, 125, 102}, {125, 100, 150, 203}};

    String[] setLastnames() {
        System.out.println("Введите фалии");
        Scanner sc = new Scanner(System.in);
        String lastNames = sc.nextLine().trim();
        return lastNames.split(" ");
    }

    int[][] setSalaryPetQuart(final String lastNames[]) {
        int salary[][] = new int[lastNames.length][];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < lastNames.length; i++) {
            System.out.println("Укажите зарплату за каждый из 4 кварталов для работника " + lastNames[i]);
            String line = sc.nextLine().trim();
            String salPerEmpl[] = line.split(" ");
            int salPerEmplInt[] = new int[4];
            for (int k = 0; k < salPerEmpl.length; k++) {
                salPerEmplInt[k] = Integer.parseInt(salPerEmpl[k]);
            }
            salary[i] = salPerEmplInt;
        }
        return salary;
    }

    void getSalaryTable(String lastNames[], int salary[][]) {
        int total = 0;
        for (int i = 0; i < lastNames.length; i++) {
            System.out.printf("%-10s", lastNames[i]);
            int sum = 0;
            for (int k = 0; k < salary[i].length; k++) {
                System.out.printf("% -2d Q    % -4dK$    ", k + 1, salary[i][k]);
                sum += salary[i][k];
            }
            System.out.printf("%-5dyear", sum);
            total += sum;
            System.out.println();
        }
        System.out.println("Общая сумма выплат: " + total);
    }

}
