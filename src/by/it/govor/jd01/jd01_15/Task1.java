package by.it.govor.jd01.jd01_15;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;


     class Task1 {
     static void task1() {
        int[][] s = new int[4][4];
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {
                s[i][j]= new Random().nextInt(30)-15;
                System.out.print(s[i][j]);
            }
            System.out.println();
        }
        File file = new File(System.getProperty("user.dir")+"/src/by/it/govor/jd01/jd01_15/text1.txt");
        try(FileOutputStream outFile = new FileOutputStream(file)){
            for (int i = 0; i <4 ; i++) {
                for (int j = 0; j <4 ; j++) {
                    outFile.write(s[i][j]);
                }
            }

        }catch (Exception e){
            System.out.println("Ошибка записи: "+e);
        }
    }
}
