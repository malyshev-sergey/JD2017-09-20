package by.it.matusevich.jd01_04;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by sergei on 29.09.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        for (int i = 2; i<10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.print(j+" * " +i+" = "+(i*j)+ "\t");
            }
            System.out.println();
        }
//        String[] cols = Utils.getCols();
        String[] cols = "4 0 3 1 2 ".split(" ");
        Utils.writeCols(cols);
        String [] sorted = Utils.sort(cols);
        Utils.writeCols(sorted);
        int firstIndex = Utils.calcIndex(sorted, cols[0]);
        int lastIndex = Utils.calcIndex (sorted, cols[cols.length-1]);
        System.out.println("\nPerviy bil, stal: "+firstIndex);
        System.out.println("\nPosledniy bil, stal: "+lastIndex);




    }
}
