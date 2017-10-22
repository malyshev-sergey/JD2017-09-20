package by.it.dubrova.jd01_13;

import java.io.*;
import java.util.*;
import java.lang.*;

public class TaskA {

    public static String getLineFromKeyboard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        return line;
    }

    public static double sum(double x, double y) {
        return x + y;
    }

    public static void main(String[] args) throws IOException {

        List<Double> lst = new ArrayList<>();
        String line = null;
        double d = 0;

        System.out.println("Привет! Вводи числа, а я буду их суммировать! END - для выхода!");

        while (true) {
            line = getLineFromKeyboard();
            if (line.equals("END")) {
                System.out.println("Программа остановлена пользователем!");
                break;
            }
            // тут мы смотрим - если строка не конвертится в доубл - то исключение
            try {
                d = Double.parseDouble(line);
            }
            catch (NumberFormatException nfe){
                System.out.println("Пожалуйста, вводите только double!");
                continue;
            }
            catch (Exception exp){
                System.out.println("Какая-то ошибка... Хм...");
                continue;
            }


            lst.add(d);
            d = 0;
            for (int i = 0; i < lst.size(); i++)
                d += lst.get(i);

            System.out.println("Сумма введенных элементов: " + d);
        }





    }
}
