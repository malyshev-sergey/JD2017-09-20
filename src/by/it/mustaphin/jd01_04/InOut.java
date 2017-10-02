package by.it.mustaphin.jd01_04;

import java.util.Scanner;

public class InOut {

    int[] in1D() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целочисленные значения через пробел");
        String line = sc.nextLine().trim();
        String masStr[] = line.split(" ");
        int masInt[] = new int[masStr.length];
        for (int i = 0; i < masStr.length; i++) {
            masInt[i] = Integer.parseInt(masStr[i]);
        }
        return masInt;
    }

    void out1D(int mas[], int cols, String name) {
        int col = 0;
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%-3s[% -2d]=%-2d", name, i, mas[i]);
            col++;
            if (col == cols) {
                System.out.println();
                col = 0;
            }
        }
    }

    void boubleSort1D(int mas[]) {
        for (int i = mas.length - 1; i > 0; i--) {
            for (int k = 0; k < i; k++) {
                if (mas[k] > mas[k + 1]) {
                    int swap = mas[k + 1];
                    mas[k + 1] = mas[k];
                    mas[k] = swap;
                }
            }
        }
    }

    void showNewPlaces(int oldMas[], int newMas[]) {
        System.out.println("Новые индексы значений");
        for (int i = 0; i < newMas.length; i++) {
            if (newMas[i] == oldMas[0] || newMas[i] == oldMas[oldMas.length - 1]) {
                System.out.printf("[% -2d]=% -2d", i, newMas[i]);
                System.out.println();
            }
        }
    }

}
