package by.it.halai.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vitaly Halai
 */
public class TaskB {

    static void solveTaskB1() {
        Pattern p = Pattern.compile("[яыуаиеоюэёЯЫУАИЕОЮЭЁ]+");
        StringBuilder sb = new StringBuilder(Data.TXT);
        
        Matcher m = p.matcher(sb);
        int count = 0;
        while (m.find()) {
            if ()
        }


    }
}
