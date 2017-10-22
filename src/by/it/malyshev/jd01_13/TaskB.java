package by.it.malyshev.jd01_13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author Sergey Malyshev
 */

public class TaskB {

    public static void main(String[] args) {
        //другая ошибка, обработать тут
        System.out.println("Запущена процедура уровеня 0");
        Random r = new Random();

        List<Integer> a = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            a.add(r.nextInt(10) + 1);
        }
        Iterator<Integer> itr = a.iterator();
        try {
            while (itr.hasNext()) {
                itr.remove();
            }
        } catch (IllegalStateException e) {
            System.err.println("Ошибка уровня 0. " + e.toString() + " метод remove() итератора вызван без next()");
        }


        try {
            int b = r.nextInt(5) + 1;
            firstLevel(b);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка уровня 1. Обращение к [" + e.getMessage() + "] элементу массива из 5 элементов");
        } catch (ArithmeticException e) {
            System.err.println("Ошибка уровня 2. Невозможно вычислть квадратный корень из " + e.getMessage());
        }
        System.out.println("Завершена процедура уровня 0");
    }


    private static void firstLevel(int i) throws ArrayIndexOutOfBoundsException, ArithmeticException {
        //другая ошибка, передать наверх, обработать в main
        System.out.println("Запущена процедура уровеня 1");
        Random r = new Random();
        int q = r.nextInt(2) - 1;
        int[] a = {1, 2, 3, 4, 5};
        try {
            a[i] = i;
            secondLevel(q);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            throw e;
        }
        System.out.println("Завершена процедура уровня 1");
    }

    private static void secondLevel(int q) throws ArithmeticException {
        //извлечение корня из отрицательного числа, передать наверх, обработать в main
        System.out.println("Запущена процедура уровеня 2");

        int a = 1;
        int b = 0;
        try {
            if (0 > q) {
                throw new ArithmeticException(String.valueOf(q));
            }

            q += Math.sqrt(q);
            thirdLevel(a, b);
        } catch (ArithmeticException e) {
            throw e;
        }
        System.out.println("Завершена процедура уровня 2");
    }

    private static void thirdLevel(int a, int b) {
        //деление на ноль, обработать тут
        System.out.println("Запущена процедура уровеня 3");

        try {
            a += a / b;
        } catch (ArithmeticException e) {
            System.err.println("Ошибка уровня 3. Нельзя " + e.getMessage());
        }
        System.out.println("Завершена процедура уровня 3");
    }

}
