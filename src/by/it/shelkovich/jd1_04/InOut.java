package by.it.shelkovich.jd1_04;

class InOut {
    /**
     * Читает строку чисел, разделённых пробелом, из консоли и преобразовывает её в одномерный массив
     *
     * @return Одномерный массив double
     */
    static double[] readArray() {
        System.out.println("Введите несколько чисел через пробел:");
        return readArrayLine(Util.readLine().trim());
    }

    /**
     * Читает несколько (пользователь предварительно вводит) строк чисел, разделённых пробелом, и преобразовывает их в двумерный массив
     *
     * @return Двумерный массив double
     */
    static double[][] read2DArray() {
        System.out.println("Enter row count");
        int rowCount = Integer.parseInt(Util.readLine());
        System.out.printf("Enter %d lines of array elements divided by space%n", rowCount);

        double result[][] = new double[rowCount][];

        for (int i = 0; i < rowCount; i++) {
            result[i] = readArrayLine(Util.readLine());
        }
        return result;
    }

    private static double[] readArrayLine(String line) {

        String[] lineElements = line.split(" ");
        double[] arrLine = new double[lineElements.length];

        for (int i = 0; i < lineElements.length; i++) {
            arrLine[i] = Double.parseDouble(lineElements[i]);
        }

        return arrLine;
    }

    /**
     * Выводит в консоль одномерный массив double
     *
     * @param name  имя массива
     * @param array одномерный массив double
     * @param cols  количество столбцов вывода
     */
    static void printArray(String name, double[] array, int cols) {
        int colsPrinted = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%d] = %4.2f  ", name, i, array[i]);
            colsPrinted++;
            if (colsPrinted == cols) {
                System.out.println();
                colsPrinted = 0;
            }
        }
        System.out.println();
    }

    /**
     * Выводит в консоль двумерный массив double
     *
     * @param array двумерный массив double
     */
    static void printArray(double[][] array) {
        for (double[] arrayLine : array) {
            printArray("", arrayLine, arrayLine.length);
        }
    }

}
