package by.it.shishov.jd01_06;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Сергей on 06.10.2017.
 */
public class TaskB1 {
    static void solveTaskB1(){
        String glasnaya = "[^аоиеёэыуюя]";
        StringBuilder sb = new StringBuilder(Data.TXT);
        Pattern p = Pattern.compile("[^а-яА-ЯёЁ]");
        Matcher m = p.matcher(sb);

        String[] words = Data.TXT.split(p.pattern());
        int pos = 0;
        for (String word: words
             ) {
            if(pos == 0){

            }
        }

    }
    private static void check(){
        Pattern p = Pattern.compile("[^а-яА-ЯёЁ]");
    }
}
