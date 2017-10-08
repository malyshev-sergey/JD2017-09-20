package by.it.matusevich.jd01_04;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Utils {
    public static String [] getCols() throws IOException {
        try(BufferedReader stin = new BufferedReader(new InputStreamReader(System.in))) {
            return stin.readLine().split(" ");
        }
    }

    public static void writeCols(String[] cols) {
        for(int i=0; i<cols.length; i++)
            System.out.print(i + " " + cols[i] + "\t");
        System.out.println();
    }

    public static String[] sort(String[] cols) {
        String [] sorted = cols.clone();
        Arrays.sort(sorted);
        return sorted;
    }

    public static int calcIndex(String[] sorted, String col) {

        return Arrays.asList(sorted).indexOf(col);
    }
    static String readLine() {
        InputStreamReader isReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isReader);
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return line;
    }
}
