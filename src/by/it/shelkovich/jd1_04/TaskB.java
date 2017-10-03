package by.it.shelkovich.jd1_04;

public class TaskB {
    private String[] surnames;
    private int[][] salaries;

    public TaskB(){
        System.out.println("Введите строку с фамилиями (через пробел)");
        surnames = Util.readLine().split(" ");
        salaries = new int[surnames.length][4];
        for (int i = 0; i < surnames.length; i++) {
            System.out.printf("Введите зарплаты по кварталам (4шт через пробел) для %s\n", surnames[i]);
            String[] str = Util.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                salaries[i][j] = Integer.parseInt(str[j]);
            }
        }
    }

    void printSummary(){
        int totalSumm = 0;
        for (int i = 0; i < salaries.length; i++) {
            System.out.printf("%-10s",surnames[i]);
            int summ = 0;
            for (int j = 0; j < 4; j++) {
                System.out.printf(" %5d",salaries[i][j]);
                summ += salaries[i][j];
            }
            System.out.printf(" | Всего за год: %d",summ);
            totalSumm += summ;
            System.out.println();
        }
        System.out.printf("Общая сумма выплат: %d", totalSumm);
    }
}
