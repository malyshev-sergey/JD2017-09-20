package by.it.mustaphin.jd01_03;

public class Runner {

    public static void main(String[] args) {
        InOut.out2D(InOut.in2D(), "masX2", 3);
        double mas[] = {3.3, 45.6, 88.0, 123.0, 62.18, 0.54};
        Util.boubleSort(mas, true);
        InOut.out1D(mas, "mas", 6);
    }
}
