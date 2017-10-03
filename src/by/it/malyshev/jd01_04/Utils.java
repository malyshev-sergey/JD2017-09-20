package by.it.malyshev.jd01_04;

public class Utils {

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

}
