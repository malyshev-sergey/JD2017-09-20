package by.it.malyshev.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {

        Map<String, Integer> words = new HashMap<>();
        Pattern p = Pattern.compile("[A-Za-z]+");
        Matcher m = p.matcher(Data.TXT);

        while (m.find()) {
            if (words.containsKey(m.group())) {
                words.put(m.group(), words.get(m.group()) + 1);
            } else {
                words.put(m.group(), 1);
            }
        }
        System.out.println("\nВ тексте:\n"+Data.TXT+"\n");
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.print("слово " + entry.getKey() + " встречается " + entry.getValue());


            int a=entry.getValue()/10;
            while(a>=10) a/=10;
            int b =entry.getValue()%10;
            if ((a==0||a>1) && (b == 2||b==3||b==4)) {
                System.out.println(" раза");
            } else {
                System.out.println(" раз");
            }

        }

    }

}
