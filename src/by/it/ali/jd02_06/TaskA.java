package by.it.ali.jd02_06;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TaskA {
    private static TaskA er;

    public static TaskA getTaskA() {
        if (er == null) {
            er = new TaskA();
        }
        return er;
    }

    private TaskA() {
        String filename = "src/by/it/ali/jd02_06/log.txt";
        try( PrintWriter pr = new PrintWriter(filename)) {
            for (int i = 1; i < 5; i++) {
                Date date = new Date();
                System.err.println("Ошибка "+i+" "+ date.toString());
                pr.println("Ошибка "+i+" "+ date.toString());
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
