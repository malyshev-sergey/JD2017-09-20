package by.it.meshchenko.jd01_04;

import java.io.IOException;

/**
 * Created by user on 29.09.2017.
 */
public class TaskB {
    private static int n;
    private static String[] famous;
    private static double[][] zpDB;

    static void createDB() throws IOException {
        System.out.print("Введите число людей:");
        //String line = Util.getOneLine();
        //n = Util.lineToInt(line);
        n = 4;
        System.out.print("Введите фамилии людей:");
        //line = Util.getOneLine();
        //famous = line.split(" ");
        famous = new String[]{"F1","F2","F3","F4"};
        System.out.printf("%n Введите з\\п по кварталам для %d людей:", n);
        zpDB = InOut.createTwoMass();
    }

    static void wageTable(){

        System.out.println("Таблица зарплат за 4 квартала:");
        System.out.printf("%s  %-30s%-9s%-9s%-9s%-9s%-9s%n", "#","ФИО", "1кв", "2кв", "3кв", "4кв", "за год");
        if(n == famous.length && n == zpDB.length){
            double total = 0;
            for(int i = 0; i < n; i++){
                double sum = 0;
                System.out.printf("%d. %-30s", i+1, famous[i]);
                for(int j = 0; j < zpDB[i].length; j++){
                    System.out.printf("%-7.3f  ", zpDB[i][j]);
                    sum = sum + zpDB[i][j];
                }
                System.out.printf("%-7.3f", sum);
                System.out.println();
                total = total + sum;
            }
            System.out.printf("TOTAL %69.3f", total);
        }

    }

    static void main() throws IOException{
        createDB();
        wageTable();
    }

}
