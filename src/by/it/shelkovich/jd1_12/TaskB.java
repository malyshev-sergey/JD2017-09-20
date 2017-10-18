package by.it.shelkovich.jd1_12;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Pattern;

public class TaskB {
    static void part1(){
        String[] text = Data.sourceText.split("[,;.\"!]*[ ]+[,.;\"!]*");
        Map<String, Integer> analytic = new HashMap<>();
        for(String word: text) {
            if(analytic.containsKey(word)){
                analytic.put(word,analytic.get(word)+1);
            }else{
                analytic.put(word,1);
            }
        }
        for (Map.Entry<String, Integer> word : analytic.entrySet()){
            System.out.printf("Слово \"%s\" встречается %d раз\n",word.getKey(), word.getValue());
        }
    }

    static void part2(){
        
    }
}
