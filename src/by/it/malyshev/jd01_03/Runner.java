package by.it.malyshev.jd01_03;

public class Runner {

    public static void main(String[] args) {

//        double[] oneDimDoubleArray=InOut.getDoubleArray();
        double[] oneDimDoubleArray = {1, -2, 56, -45, 37, 94, 183};
        System.out.println("Вывод одномерного массива");
        InOut.printArray(oneDimDoubleArray);
        System.out.println();

//        double[][] array=InOut.getDouble2DArray();
        double[][] array = {{2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}};
        System.out.println("Вывод двумерного массива");
        InOut.print2DArray(array);
        System.out.println();

        double max = Utils.maxDoubleArray(oneDimDoubleArray);
        double min = Utils.minDoubleArray(oneDimDoubleArray);
        System.out.printf("Максимум одномерного массива oneDimDoubleArray =%10.4f", max);
        System.out.println();
        System.out.printf("Минимум одномерного массива oneDimDoubleArray =%10.4f", min);
        System.out.println();


        Utils.sortDoubleArray(oneDimDoubleArray, true);
        InOut.printArray(oneDimDoubleArray);
        Utils.sortDoubleArray(oneDimDoubleArray, false);
        InOut.printArray(oneDimDoubleArray);
        System.out.println();

        System.out.println("Умножение матрицы на вектор");
        double[][] matrix1 = {{2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}};
        System.out.println("\nИсходная матрица");
        InOut.print2DArray(matrix1);
        double[] vector = {1, -2, 56, -45};
        System.out.println("\nИсходный вектор");
        InOut.printArray(vector);
        if (matrix1[0].length == vector.length) {
            double[] product = Utils.matrixVectorProduct(matrix1, vector);
            System.out.println("\nПродукт");
            InOut.printArray(product);
        } else
            System.out.println("Число столбцов в матрице не равно\nс числу строк в векторе-столбце");

        System.out.println();

        System.out.println("Умножение матрицы на матрицу");
        System.out.println("\nИсходная матрица A");
        InOut.print2DArray(matrix1);
        double[][] matrix2 = {{2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}};
        System.out.println("\nИсходная матрица B");
        InOut.print2DArray(matrix2);

        if (matrix1[0].length == matrix2.length) {
            double[][] product2D = Utils.matrixesProduct(matrix1, matrix2);
            System.out.println("\nПродукт");

            InOut.print2DArray(product2D);
        } else
            System.out.println("Число столбцов в матрице A не равно\nс числу строк в матрице B");


    }
}
