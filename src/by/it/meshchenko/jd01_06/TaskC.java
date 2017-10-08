package by.it.meshchenko.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    public static void competitions(String str, int go){
        Pattern p = Pattern.compile("[^а-яА-ЯёЁ]");
        String[] words = str.split(p.pattern());
        long start, end;

        start = System.currentTimeMillis();
        gamerString(words, str, go);
        end = System.currentTimeMillis();
        System.out.printf("String:");
        System.out.printf(" %d %n", end - start);

        start = System.currentTimeMillis();
        gamerStringBuilder(words, str, go);
        end = System.currentTimeMillis();
        System.out.printf("StringBuilder:");
        System.out.printf(" %d %n", end - start);
    }

    private static void gamerString(String[] words, String str, int go){
        String s = "";
        int len = 0;
        int r = 0;
        int n = words.length - 1;
        while (len < go){
            int lenAdd = words[r].length();
            if((lenAdd + len + 1) <= go){
                s = s.concat(words[r]);
                s = s.concat(" ");
                len = s.length();
            }
            else{
                s = s.concat(str.substring(0, go - len));
            }
            r = Util.randomInt(n);
        }
    }

    private static void gamerStringBuilder(String[] words, String str, int go){
        StringBuilder s = new StringBuilder("");
        int len = 0;
        int r = 0;
        int n = words.length - 1;
        while (len < go){
            int lenAdd = words[r].length();
            if((lenAdd + len + 1) <= go){
                s = s.append(words[r]).append(" ");
                len = s.length();
            }
            else{
                s = s.append(str.substring(0, go - len));
            }
            r = Util.randomInt(n);
        }
    }
}
