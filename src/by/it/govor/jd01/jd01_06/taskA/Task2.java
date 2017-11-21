package by.it.govor.jd01.jd01_06.taskA;

import by.it.govor.jd01.jd01_06.Date;

/**
 * Created by User on 05.10.2017.
 */
public class Task2 {
    public static void task2() {
        String s = Date.STR;
        String[] text= s.split("[^А-яёЁ]+");

        for (int i = 0; i <text.length ; i++) {

            if(text[i]!="%") {
                int cout=1;
                for (int j = i+1; j < text.length; j++) {
                if (text[i].equals(text[j])){
                    cout++;
                    text[j]="%";
                }
                }
                System.out.println("Слово "+text[i]+" кол-во "+cout);
            }

        }
    }
}
