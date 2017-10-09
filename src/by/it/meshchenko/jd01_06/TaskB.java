package by.it.meshchenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void firstEndVowel(String str){
        Pattern p = Pattern.compile("\\b[АОУЭЫЯЕЁЮИаоуэыяеёюи]\\b");
        Pattern p1 = Pattern.compile("\\n");
        String[] words = str.split(p1.pattern());
        int i = 0;
        while (i < words.length){
            System.out.printf("%s \n", words[i]);
            Matcher m = p.matcher(words[i]);
            while (m.find()){
                String wold = m.group();
                System.out.printf("Искомое слово - '%s'\n", wold);
            }
            i++;
        }
    }

    public static void sentenceASC(String str){
        Pattern sentence = Pattern.compile("[\\.!]{1,}");
        Pattern p = Pattern.compile("\\n");
        String[] words = str.split(sentence.pattern());
        StringBuilder[] sb = new StringBuilder[words.length];
        //int[] arr = new int[words.length];
        int i = 0;
        while (i < sb.length) {
            //arr[i] = words[i].length();
            sb[i] = new StringBuilder(words[i]);
            i++;
        }
        Util.sortByLengthLines(sb);
        i = 0;
        while (i < sb.length) {
            Matcher m = p.matcher(sb[i]);
            while (m.find()){
                sb[i].setCharAt(m.start(),' ');
            }
            System.out.printf("%s \n", sb[i]);
            i++;
        }
    }


}
