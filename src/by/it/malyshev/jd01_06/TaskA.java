package by.it.malyshev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {

    static void taskA1() {
        System.out.println("\nЗадание A1:\n");

        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder sb = new StringBuilder(RunnerSix.LUKOMOR);
        Matcher m = p.matcher(sb);
        while (m.find()) {
            sb.setCharAt(m.start() + 3, '#');
            if (m.group().length() > 6)
                sb.setCharAt(m.start() + 6, '#');
        }
        System.out.println(sb);
    }


    static void taskA2() {

        System.out.println("\nЗадание A2:\n");

        Pattern p = Pattern.compile("[^а-яА-ЯёЁ]+");
        String[] words = RunnerSix.LUKOMOR.split(p.pattern());
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
                        word, counter);
            }
            pos++;
        }
    }
}

