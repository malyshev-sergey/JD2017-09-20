package by.it.akhmelev.jd01_06.classwork;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Pattern;

public class TaskA2 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[^а-яА-ЯёЁ]+");
        String[] words = Data.TXT.split(p.pattern());
        int pos = 0;
        while (pos < words.length) {
            if (!words[pos].isEmpty()) {
                String word = words[pos];
                int counter = 1;
                for (int i = pos + 1; i < words.length; i++) {
                    if (words[i].equals(word)) {
                        counter++;
                        words[i] = "";
                    }
                    words[pos] = "";
                }
                System.out.printf("Для слова [%s] число повторов %d\n",
                        word,counter);
            }
            pos++;
        }


    }
}
