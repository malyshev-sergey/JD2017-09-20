package by.it.shishov.jd01_12;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Сергей on 23.10.2017.
 */
public class TaskB {
    static void countWords() {
        String[] text = Data.TXT.split("[^a-zA-Z]");
        Map<String, Integer> textCount = new HashMap<>();
        for (String word : text
                ) {
            if (word.equals(""))
                continue;
            if (!(textCount.containsKey(word)))
                textCount.put(word, 1);
            else
                textCount.put(word, textCount.get(word) + 1);
        }

        for (Map.Entry<String, Integer> word : textCount.entrySet()){
            System.out.println(word.getKey() + " повторяется " +word.getValue() + " раз(а)");
        }


    }

}
