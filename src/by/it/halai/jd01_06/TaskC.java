package by.it.halai.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vitaly Halai
 */
public class TaskC {

    static void solveTaskC1() {
        Pattern p = Pattern.compile("\n");
        String[] lines = Data.TXT.split(p.pattern());

        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println(lines[0].length());


    }

}
