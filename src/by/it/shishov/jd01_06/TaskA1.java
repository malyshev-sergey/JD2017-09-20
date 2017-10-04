package by.it.shishov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Сергей on 04.10.2017.
 */
public class TaskA1 {
    public static void solveTask1() {

        StringBuilder sb = new StringBuilder(Data.TXT);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher m = p.matcher(sb);
        while (m.find()) {
            sb.setCharAt(m.start() + 3, '#');
            if (m.group().length()>6){
                sb.setCharAt(m.start() + 6, '#');
            }

        }
        System.out.println(sb);


    }
}
