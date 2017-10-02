package by.it.ali.jd01_02;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Введите числа");
        String str = ReadStr.GetLine();
        int arr[] = ReadStr.lineToIntArray(str);
        TaskA.showMax(arr);
        TaskA.getMin(arr);
        double m = TaskA.sa(arr);
        for (int i : arr) {
            if (TaskA.SolveTaskA3(i)) {
                System.out.println("Найдено число из разных цифр: " + i);
                break;
                    }
                    }
        TaskB.matriz();
        TaskB.TaskB2();
        TaskB.TaskB3();
    }
}
