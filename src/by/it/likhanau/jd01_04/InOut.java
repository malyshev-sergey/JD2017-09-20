package by.it.likhanau.jd01_04;

public class InOut {
    static double[] readArray() {
        System.out.println("Enter the numbers: ");
        return readArrayLine(Util.readLine().trim());
    }


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


    static void printArray(double[][] array) {
        for (double[] arrayLine : array) {
            printArray("", arrayLine, arrayLine.length);
        }
    }

}

