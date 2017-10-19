package by.it.shelkovich.jd1_12;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.*;
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

    static void part2(int n){
        List <Integer> arrayCircle = new ArrayList<>();
        List <Integer> linkedCircle = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            arrayCircle.add(i);
            linkedCircle.add(i);
        }

        long startArray = System.currentTimeMillis();
        processList(arrayCircle);
        long stopArrStartLin = System.currentTimeMillis();
        processList(linkedCircle);
        long stopLinked = System.currentTimeMillis();

        System.out.printf("Время массива: %dc., время связанного списка: %dc.\n", (stopArrStartLin-startArray)/1000, (stopLinked - stopArrStartLin)/1000 );
    }

    private static void processList(List<Integer> circle){
        Iterator<Integer> iter = circle.iterator();
        boolean selected = false;
        while(circle.size() > 1) {
            int i;
            if (iter.hasNext()) i = iter.next();
            else {
                iter = circle.iterator();
                i = iter.next();
            }
            if (selected) {
                //System.out.printf("Элемет %d вышел из круга\n", i);
                iter.remove();
            }
            selected = !selected;
        }
        System.out.printf("В круге остался элемент %s\n", circle);
    }
}
