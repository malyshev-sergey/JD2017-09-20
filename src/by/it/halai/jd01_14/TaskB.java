package by.it.halai.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Vitaly Halai
 */
public class TaskB {
    public static void taskB() throws FileNotFoundException {
        int sump = 0;
        int sumw = 0;
        String src = System.getProperty("user.dir") + "/src/by/it/halai/";
        String filename = src + "jd01_14/scan.txt";
        File f = new File(filename);
        Scanner scan1 = new Scanner(f);
        Scanner scan2 = new Scanner(f);

        scan1.useLocale(Locale.getDefault());
        scan1.useDelimiter("[,;.!?]");     //разделитель
        while (scan1.hasNext()) {
            sumw++;
            scan1.next();
        }
        scan1.close();
        System.out.println("Количество слов = " + sumw);

        scan2.useDelimiter("[a-zA-Z]+");     //разделитель
        while (scan2.hasNext()) {
            sump++;
            scan2.next();
        }
        scan2.close();
        System.out.println("Количество знаков припинания = " + sump);
    }
}
