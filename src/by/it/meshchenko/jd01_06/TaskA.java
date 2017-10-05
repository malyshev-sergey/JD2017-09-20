package by.it.meshchenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static void replace47(String str){
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder sb = new StringBuilder(str);
        Matcher m = p.matcher(sb);
        while (m.find()){
            sb.setCharAt(m.start()+3,'#');
            if (m.group().length()>6)
                sb.setCharAt(m.start()+6,'#');
        }
        System.out.println(sb);
    }

    public static void repeatWolds(String str){
        Pattern p = Pattern.compile("[^а-яА-ЯёЁ]");
        String[] words = str.split(p.pattern());
        int pos = 0;
        while(pos < words.length){
            if (!words[pos].isEmpty()) {
                String word = words[pos];
                int count = 1;
                for (int i = pos + 1; i < words.length; i++) {
                    if (words[i].equals(word)) {
                        count++;
                        words[i] = "";
                    }
                    words[pos] = "";
                }
                System.out.printf("Cлово '%s' - число повторов %d\n", word,count);
            }
            pos++;
        }
    }
}
