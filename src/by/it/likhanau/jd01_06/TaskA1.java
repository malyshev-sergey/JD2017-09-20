package by.it.likhanau.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskA1 {
    public static void change4And7Symbol(String Poem) {
        StringBuilder text = new StringBuilder(Poem);
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]{4,}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int wordStart = matcher.start();
            int wordLength = matcher.group().length();
            text.setCharAt(wordStart + 3, '#');
            if (wordLength > 6) {
                text.setCharAt(wordStart + 6, '#');
            }
        }
        System.out.println(text);
    }
}
