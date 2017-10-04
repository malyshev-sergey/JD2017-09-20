package by.it.malyshev.jd01_02;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {

        System.out.println("Введите через пробел целые числа типа");
        String line = Utils.getOneLine();
//        String line = "11 22 343 67 456 333 22 853";

        int arr[] = Utils.lineToIntArray(line);

        //TaskA1.solveTaskA1(line);

        //TaskA1 вывести самое длинное и самое короткое число и его длину
        System.out.println("Задание A1:");
        String max = TaskA.getMax(arr);
        System.out.println(max);
        String min = TaskA.getMin(arr);
        System.out.println(min);

        //вывести на консоль числа, длина которых меньше средней
        System.out.println("Задание A2:");
        double mean = TaskA.mean(arr);
        System.out.print("Числа меньше " + (int) mean + " таковы: ");
        for (int i : arr) {
            if (i < mean) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.println("Задание B1:");
        //найти первое из чисел, состоящих из разных цифр
        for (int i : arr) {
            if (TaskA.uniqueDigits(i)) {
                System.out.println("Найдено число из разных цифр: " + i);
                break;
            }
        }

        System.out.println("\nЗадание В1:вывод чисел в виде квадратной матрицы\nВведите целое число N");
        String lineA = Utils.getOneLine();
        int n1 = Integer.parseInt(lineA);
//        int n1=25;
        TaskB.matrix(n1);

        System.out.println("\nЗадание В2:решение квадратного уравнения");
        System.out.println("Введите через пробел a, b и c параметры квадратного уравнения\n");
        String lineParamQuadraticEquation = Utils.getOneLine();
        double arrParamQuadraticEquation[] = Utils.lineToDoubleArray(lineParamQuadraticEquation);
//        double arrParamQuadraticEquation[] = {-1, 5, 8};
        TaskB.rootsOfQuadraticEquation(arrParamQuadraticEquation);

        System.out.println("\n\nЗадание В3:\nВведите номер месяца");
        String lineNumberOfMonth = Utils.getOneLine();
        int numberOfMonth = Integer.parseInt(lineNumberOfMonth);
//        int numberOfMonth = 4;
        TaskB.NumberToMonth(numberOfMonth);

        System.out.println("\n\nЗадание С:\n");
//        System.out.println("Введите матрицу");
//        double[][] matrixA=TaskC.getDouble2DArray();
//        int[][] matrixA = {{145, -12,  0,  14, 15},
//                           {145, -22,  0, 145, 25},
//                           {145,   0, 33,  34, 35},
//                           {41,  -42, 43,  44, 45}};

        System.out.println("Введите N размерность квадратной матрицы");
        String lineB = Utils.getOneLine();
        int n2 = Integer.parseInt(lineB);
//        int n2=5;

        System.out.println("\nгенерация случайной матрицы NxN");
//        TaskC.print2DArray(matrixA);
        System.out.println();
        int[][] matrixB = TaskC.getRandomDouble2DArray(n2, n2, n2);
        TaskC.print2DArray(matrixB);

        System.out.println("\nтранспонирование матрицы");
        int[][] matrixC = TaskC.transposeMatrix(matrixB);
        TaskC.print2DArray(matrixC);

        System.out.println("\nповорот матрицы на 90 градусов против часовой стрелки");
        int[][] matrixD = TaskC.rotateMatrix(matrixB);
        TaskC.print2DArray(matrixD);

        System.out.println("\nперенос минимального элемента в первую позицию путем перестановки строк и столбцов");
        int[][] matrixE = TaskC.moveMinTofirstPosition(matrixB);
        TaskC.print2DArray(matrixE);

        System.out.println("\nсумма элементов матрицы, расположенных между первым");
        System.out.println("и вторым положительными элементами каждой строки = " + TaskC.positiveSum(matrixB));

        System.out.println("\nудаление из матрицы всех строк и столбцов, содержащих максимальные элементы");
        int[][] matrixG = TaskC.deleteMaxRowCol(matrixB);
        if (0 == matrixG.length) System.out.println("Все строки и столбцы удалены");
        else TaskC.print2DArray(matrixG);

        System.out.println("\nразмещение элементов, равных нулю, после всех остальных");
        int[][] matrixF = TaskC.nullsToEnd(matrixB);
        TaskC.print2DArray(matrixF);


    }
}
