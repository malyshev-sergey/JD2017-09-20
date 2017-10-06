package by.it.dubrova.jd01_03;

public class Util {
    static double getMinValueFromArray(double[] d){
        double min = d[0];

        for (int i = 0; i < d.length; i++){
            if (d[i] < min)
                min = d[i];
        }

        return min;
    }

    static double getMaxValueFromArray(double[] d){
        double max = d[0];

        for (int i = 0; i < d.length; i++){
                if (d[i] > max)
                max = d[i];
        }

        return max;
    }

}
