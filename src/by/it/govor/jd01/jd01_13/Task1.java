package by.it.govor.jd01.jd01_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 20.10.2017.
 */
public class Task1 {
    public static void task1() {

            try {
                while (true) {
                    BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
                    double d = Double.parseDouble(s.readLine());
                   double c= Math.sqrt(d);
                    System.out.println(c);
                }
            } catch (NumberFormatException e){
                System.out.println("Ошибка неправильного ввода: "+e);
            }

              catch (IOException e){
                  System.out.println("Ошибка нахождения корня: "+e);
              }
    }
}