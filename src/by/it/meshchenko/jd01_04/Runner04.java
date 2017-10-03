package by.it.meshchenko.jd01_04;

import by.it.meshchenko.jd01_03.*;

import java.io.IOException;

/**
 * Created by user on 29.09.2017.
 */
public class Runner04 {
    public static void main(String[] args) throws IOException {
        //A.1. Напишите код для вывода таблицы умножения в виде:
        TaskA.multiplicationTable();

        //A.2.1. выполняет ввод, а затем вывод в 5 колонок одномерного
        //    массива с названием и индексами
        //double[] arr1 = InOut.createOneMass();
        //InOut.printOneMass(arr1);

        //A.2.2. сортирует этот массив по возрастанию и выводит его в 4 колонки
        //Util.quickSort(arr1);
        //InOut.printOneMass(arr1, 4);

        //A.2.3. выполняет вычисление новых (после сортировки) индексов
        //       первого и последнего элемента исходного массива.
        //TaskA.searchFirstLasstElements();

        //B     Введите N число людей и одномерный массив их фамилий.
        //      Введите двумерный массив их зарплат за 4 квартала (N строк и 4 столбца).
        //      Постройте в консоли таблицу доходов людей по кварталам с
        //      фамилиями и итогом за год в последней колонке.
        //      Посчитайте и выведите общую сумму выплат.
        TaskB.main();
    }
}
