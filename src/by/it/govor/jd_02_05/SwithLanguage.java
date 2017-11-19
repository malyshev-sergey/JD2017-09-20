package by.it.govor.jd_02_05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwithLanguage {
    public static void swithLanguage() {
        System.out.println("Введите RU,BY,EN или Null");
        try (BufferedReader b = new BufferedReader(new InputStreamReader(System.in))) {

            String language = b.readLine();
        } catch (IOException e){
            System.out.println("Ошибка чтения: "+e);
        }


    }
}
