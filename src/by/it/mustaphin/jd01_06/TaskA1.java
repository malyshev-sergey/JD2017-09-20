package by.it.mustaphin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA1 {

    private StringBuilder builder = new StringBuilder(Util.TXT);
    private Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{5,}");
    private Matcher matcher = pattern.matcher(builder);

    void replaceSymbs() {
        while (matcher.find()) {
            int start = matcher.start();
            int length = matcher.group().length();
            builder.setCharAt(start, '#');
            if (length > 6) {
                builder.setCharAt(start + 6, '#');
            }
        }
        System.out.println(builder);
    }

}
