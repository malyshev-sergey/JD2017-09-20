package by.it.dubrova.jd01_15;

import java.io.FileWriter;
import java.io.IOException;

public class TaskA {
    public static int rnd(){
        int i = (int)(Math.random()*15);
        int j = -(int)(Math.random()*15);
        double cnt = Math.random();
        if (cnt<0.5) return i;
        return j;
    }

    public static void main(String[] args) throws IOException {
        int matrix[][] = new int[4][4];

        FileWriter f = null;
        try {
            f = new FileWriter("D:\\JavaAcademy\\GitHub\\JD2017-09-20\\out\\production\\JD2017-09-20\\by\\it\\dubrova\\jd01_15\\matrix.txt",true);

            for (int i = 0; i < 4; i++){
                System.out.println();
                f.write("\r\n");
                for (int j = 0; j < 4; j++){
                    matrix[i][j] = rnd();
                    System.out.print(matrix[i][j] + "\t");
                    f.write(matrix[i][j] + "\t");
                }
            }

            f.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            f.close();
        }


    }
}
