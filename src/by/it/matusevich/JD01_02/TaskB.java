package by.it.matusevich.JD01_02;
import java.util.Scanner;

/**
 * Created by sergei on 07.10.2017.
 */
public class TaskB {
    public static void massiv(int ar) {
        int cols = 0;
        System.out.println("Vyvod chisel massiva " + ar);
        for (int i = 1; i <= ar; i++) {
            System.out.printf("%-9d", i);
            cols++;
            if ((cols % Math.round(Math.sqrt(ar)) == 0)) {
                System.out.println();
            }

        }
    }
    public static void month(int num) {
        switch (num) {
            case 1: {
                System.out.println("Jan");
                break;
            }
            case 2: {
                System.out.println("Feb");
                break;
            }
            case 3: {
                System.out.println("Mar");
                break;
            }
            case 4: {
                System.out.println("Apr");
                break;
            }
            case 5: {
                System.out.println("May");
                break;
            }
            case 6: {
                System.out.println("Jun");
                break;
            }
            case 7: {
                System.out.println("Jul");
                break;
            }
            case 8: {
                System.out.println("Aug");
                break;
            }
            case 9: {
                System.out.println("Sep");
                break;
            }
            case 10: {
                System.out.println("Oct");
                break;
            }
            case 11: {
                System.out.println("Nov");
                break;
            }
            case 12: {
                System.out.println("Dec");
                break;
            }
            default: {
                System.out.println("Wrong number ");
            }
        }
    }
}


