package by.it.Biazverkhi.jd01_02;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        //прочитам линию значений с клавиатуры.
        String line = Utils.getOneLine();
        // String line="44 11 22 343 123 67 456 333 22 853";
        //получим массив чисел с которым будем работать:
        int arr[] = Utils.lineToIntArray(line);
        System.out.println(line);
        //1. Найти самое короткое и самое длинное число.
        // Вывести найденные числа и их длину.
        String max = TaskA.getMax(arr);
        System.out.println(max);
        String min = TaskA.getMin(arr);
        System.out.println(min);
        //2. Вывести на консоль те числа, длина которых меньше.
        // (больше) средней.
        double mean = TaskA.mean(arr);
        System.out.printf("Числа меньше %.4f таковы: ", mean);
        for (int i : arr) {
            if (i < mean) {
                System.out.print(i + " ");
            }
        }
        System.out.print(", а числа больше " + mean + " таковы: ");
        for (int i : arr) {
            if (i > mean) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        //3. Найти число, состояние только из различных цифр.
        //Если таких чисел несколько, найти первое из них.
        System.out.print("Найдено число из разных цифр: ");
        for (int i : arr) {
            if (TaskA.uniqueDigits(i)) {
                System.out.printf("%d, ", i);
            }
//            if (TaskA.uniqueDigits(i)) {
//            }

            // break; //больше ничего не идем
        }
        //4. Задание на B
        System.out.println("");
        System.out.println("Ведите любое число, из которого возможно извлечение корня без остатка");
        String i = Utils.getOneInt();
        double N = Double.parseDouble(i);
        double n = Math.sqrt(N);
        int M = (int) n;

        System.out.println("вывожу матрицу с размерностью " + M + " на " + M + " элементов:");
        int[][] array = TaskC.Array(M);
        TaskC.printArray(array);

       //вывожу ссумы двух первых положительных элементов в строках
        TaskC.sumArray(array);

        System.out.println(" ");

        System.out.println("вывожу транспонированную матрицу: ");
        int[][] trans = TaskC.transArray(array, M);
        TaskC.printArray(trans);
        System.out.println(" ");

        System.out.println("вывожу матрицу с поворотом на 90градусов против часовой стрелки  и рядом с ней первоначальную для удобства сравнения: ");
        System.out.println(" ");

        int[][] rotate = TaskC.rotArray(array, M);
      TaskC.printArray2(rotate, array);

//ищу максимальное число для удаления
//  и вывожу массив без заданных строк и столбцов
TaskC.searchAndDelArray(rotate, M);





        //TaskC.printArray(searchDel, M);
//System.out.print(searchDel);

    }

}
