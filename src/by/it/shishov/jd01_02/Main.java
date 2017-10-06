package by.it.shishov.jd01_02;

public class Main {

    public static void main(String[] args) {
        // ----- ЗАДАНИЕ А1 ----
        String myLine = TaskA.getMyLine();
        int[] myArr = TaskA.ParseLine(myLine);
        TaskA.getMinValue(myArr);
        TaskA.getMaxValue(myArr);
        // ---- ЗАДАНИЕ А2 ----
        TaskA.showNumbersBelowAverage(myArr);
        // ---- ЗАДАНИЕ А3 ----
        TaskA.checkUniqueDigits(myArr);
        // ---- ЗАДАНИЕ B1 ----
        TaskB.printArr(25);
        // ---- ЗАДАНИЕ B2 ----
        TaskB.quadraticEquation();
        // ---- ЗАДАНИЕ B3 ----
        TaskB.monthCase();
    }


}

