package by.it.mustaphin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    Pattern pattern = Pattern.compile("[\\.!]{1,}");
    Matcher matcher = pattern.matcher(Util.TXT);
    String text[];

    void seekLengthParts() {
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
