package by.it.matusevich.jd01_03;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Double[] doubles = InOut.masDouble();
        double max = Utils.getMax(doubles);
        double min = Utils.getMin(doubles);
        System.out.println("Minimum ravno: "+ min);
        System.out.println("Maximum ravno: "+ max);
    }


}
