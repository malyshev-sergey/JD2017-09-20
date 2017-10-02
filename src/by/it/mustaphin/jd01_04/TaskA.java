package by.it.mustaphin.jd01_04;

public class TaskA {
    public void multiple() {
        for (int i = 2; i <= 9; i++) {
            for (int k = 2 ; k <= 9; k++) {
                System.out.printf("%1d*%1d=%-2d ", i, k, i * k);
            }
            System.out.println();
        }
    }
}
