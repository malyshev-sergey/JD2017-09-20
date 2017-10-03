package by.it.meshchenko.jd01_02;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException{
        //прочитаем линию с клавиатуры
        //String line = Util.getOneLine();
        String line = "1 22 333 4444 55555 666666 7777777 123 4567 89898";
        int[] arr = Util.lineToInArray(line);

        //A.1. Найти самое короткое и самое длинное в написании число.
        // Вывести найденные числа и их длину.
        System.out.println("A.1.");
        String max = TaskA.getMax(arr);
        System.out.println(max);
        String min = TaskA.getMin(arr);
        System.out.println(min);

        //A.2. Вывести на консоль те числа, значение которых меньше
        // среднего арифметического.
        System.out.println("A.2.");
        double mean = TaskA.mean(arr);
        System.out.print("Числа меньше " + mean + " таковы: ");
        for(int i:arr){
            if(i < mean){
                System.out.print(i + " ");
            }
        }
        System.out.println();

        //A.3. Найти число, состоящее только из различных цифр.
        // Если таких чисел несколько, найти первое из них.
        System.out.println("A.3.");
        for(int i :arr){
            if(TaskA.uniqueDigits(i)){
                System.out.println("Найдено число из разных цифр: " + i);
                break; //больше ничего не ищем
            }
        }

        //B.1 Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз
        // (k выберите квадратом целого числа, например – 25, т.е. N будет = 5).
        System.out.println("B.1.");
        String lineB1 = "1 22 33 44 55 66 7 123 467 98 1 22 33 44 55 66 7 123 467 98 12 13 14 15 16";
        int[] arrB1 = Util.lineToInArray(lineB1);
        TaskB.strMatrix(arrB1);

        //B.2 Рассчитайте и выведите корни квадратного уравнения. Параметры (a b c)
        // уравнения нужно передавать с командной строкой.
        System.out.println("\nB.2.");
        System.out.println("Введите через пробел параметры a, b ,c квадратного уравнения");
        String lineB2 = Util.getOneLine();
        int[] arrB2 = Util.lineToInArray(lineB2);
        TaskB.quadratic(arrB2);

    }
}
