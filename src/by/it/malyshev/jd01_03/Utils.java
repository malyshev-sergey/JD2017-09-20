package by.it.malyshev.jd01_03;

public class Utils {

    /**
     * Finding the maximum for the Double array
     *
     * @param doubleArray a one-dimensional Double array
     * @return a maximum or Double.MAX_VALUE if the array is empty
     */

    static double maxDoubleArray(double[] doubleArray) {
        if (0 == doubleArray.length) {
            return Double.MAX_VALUE;
        } else {
            double maxDouble = doubleArray[0];
            for (double m : doubleArray) {
                if (m > maxDouble) maxDouble = m;
            }
            return maxDouble;
        }
    }

    /**
     * Finding the minimum for a double array
     *
     * @param doubleArray a one-dimensional double array
     * @return the minimum or Double.MIN_VALUE if the array is empty
     */

    static double minDoubleArray(double[] doubleArray) {
        if (0 == doubleArray.length) {
            return Double.MIN_VALUE;
        } else {
            double minDouble = doubleArray[0];
            for (double m : doubleArray) {
                if (m < minDouble) minDouble = m;
            }
            return minDouble;
        }
    }

    /**
     * Sorting of a one-dimensional double array
     *
     * @param doubleArray a one-dimensional double array
     * @param upDirection true or false will return ascending or descnding order, respectively,
     * @return the sorted one-dimensional double array
     */
    static double[] sortDoubleArray(double[] doubleArray, boolean upDirection) {
        for (int i = 0; i < doubleArray.length - 1; i++)
            for (int j = i + 1; j < doubleArray.length; j++)
                if ((upDirection && doubleArray[i] > doubleArray[j]) ||
                        (!upDirection && doubleArray[i] < doubleArray[j])) {
                    double d = doubleArray[i];
                    doubleArray[i] = doubleArray[j];
                    doubleArray[j] = d;
                }
        return doubleArray;
    }

    /**
     * The product of a matrix multiplied by a column matrix
     *
     * @param matrix a two-dimensional matrix
     * @param vector a column vector
     * @return the column product matrix
     */
    static double[] matrixVectorProduct(double[][] matrix, double[] vector) {
        double[] product = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                product[i] = product[i] + matrix[i][j] * vector[j];
        return product;
    }

    /**
     * The product of  a matrix A multiplied by a matrix B
     *
     * @param matrixA a two-dimensional matrix
     * @param matrixB a two-dimensional matrix
     * @return a two-dimensional product matrix
     */
    static double[][] matrixesProduct(double[][] matrixA, double[][] matrixB) {
        double[][] product = new double[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++)
            for (int j = 0; j < matrixB[0].length; j++)
                for (int k = 0; k < matrixB.length; k++)
                    product[i][j] = product[i][j] + matrixA[i][k] * matrixB[k][j];
        return product;
    }


}
