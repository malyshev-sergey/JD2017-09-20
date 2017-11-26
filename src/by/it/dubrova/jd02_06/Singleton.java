package by.it.dubrova.jd02_06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

public class Singleton {
    private static Singleton ourInstance = new Singleton();
    private String error;

    public static Singleton showError() {
        return ourInstance;
    }

    private Singleton() {
        String filename = "src/by/it/dubrova/jd02_06/log.txt";
        try( PrintWriter pr = new PrintWriter(new FileOutputStream(new File(filename),true))) {

            Date date = new Date();
            System.err.println("Ошибка " + date);
            pr.println("Ошибка  " + date);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}
