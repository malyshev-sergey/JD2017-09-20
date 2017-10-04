package by.it.shishov.jd01_04;

import by.it.halai.jd01_04.InOut;

public class Main {


    public static void main(String[] args) {

        //-----ЗАДАНИЕ А1----
        inOut.printMultiplicationTable();
        //-----ЗАДАНИЕ А2-------
        String line = inOut.consoleReadLine();
        // Сплитим строку в массив типа double
        double[] arr = inOut.stringLineToDoubleArray(line);
        //Выводим массив на экран
        inOut.printArr(arr, "arr", 4);
        // Сортируем массив по возрастанию(true)
        double[] sortedArr = Utils.sortArr(arr, true);
        // Выводим отсортированный массив
        inOut.printArr(sortedArr, "arr", 4);
        Utils.findIndexes(arr, sortedArr);
        //----ЗАДАНИЕ B---
        TaskB.getSurnames();
        TaskB.getSalary();
        TaskB.printSalaryTable();


    }
}
