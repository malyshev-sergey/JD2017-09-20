package by.it.halai.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vitaly Halai
 */
public class TaskA {
    static void solveTaskA1() {

        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder sb = new StringBuilder(Data.TXT);
        Matcher m = p.matcher(sb);
        while (m.find()) {
            sb.setCharAt(m.start() + 3, '#');
            if (m.group().length() > 6) {
                sb.setCharAt(m.start() + 6, '#');
            }
            System.out.println(m.group());
        }
    }

    static void solveTaskA2() {
        Pattern p = Pattern.compile("[^а-яА-ЯёЁ]+");
        String[] words = Data.TXT.split(p.pattern());
        int pos = 0;
        while (pos < words.length) {
            if (words[pos].length() > 0) {
                String word = words[pos];
                int counter = 1;
                for (int i = pos + 1; i < words.length; i++) {
                    if (words[i].equals(word)) {
                        counter++;
                        words[i] = "";
                    }
                    words[pos] = "";
                }
                System.out.printf("Для слова [%s] число повторов %d\n", word, counter);
            }
            pos++;
        }

    }

}
