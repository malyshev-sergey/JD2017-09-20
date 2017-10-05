package by.it.shelkovich.jd1_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    static void part1() {
        StringBuilder srcText = new StringBuilder(Source.sourceText);
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]{4,}");
        Matcher matcher = pattern.matcher(srcText);
        while (matcher.find()) {
            srcText.setCharAt(matcher.start(), '#');
            if (matcher.group().length() > 6) srcText.setCharAt(matcher.start() + 6, '#');
        }
        System.out.println(srcText);
    }

    static void part2() {
        String[] strArray = Source.sourceText.split("[^А-Яа-яЁё]+");
        for (int i = 0; i < strArray.length - 1; i++) {
            int count = 1;
            if (strArray[i].length() == 0) continue;
            for (int j = i + 1; j < strArray.length; j++) {
                if (strArray[i].equals(strArray[j])){
                    count++;
                    strArray[j] = "";
                }
            }
            System.out.printf("Слово \"%s\" встречается %-2d раз\n", strArray[i], count);
        }
    }
}
