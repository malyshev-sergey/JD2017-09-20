package by.it.shelkovich.jd1_12;

import java.util.*;

public class TaskA {
    static void part1(){
        List<Integer> marks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            marks.add((int)Math.round(Math.random()*9)+1);
        }
        System.out.println("Исходные оценки:");
        System.out.println(marks);
        List<Integer> positiveMarks = new ArrayList<>(marks);
        Iterator<Integer> iter = positiveMarks.iterator();
        while (iter.hasNext()){
            Integer i = iter.next();
            if (i<5) iter.remove();
        }
        System.out.println("Оценки после фильтрации:");
        System.out.println(positiveMarks);
    }

    static void part2(){
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            setA.add((int)Math.round(Math.random()*30));
            setB.add((int)Math.round(Math.random()*30));
        }
        System.out.println("Исходное множество А:");
        System.out.println(setA);
        System.out.println("Исходное множество B:");
        System.out.println(setB);
        System.out.println("Пересечение множеств:");
        System.out.println(MyCollect.getCross(setA, setB));
        System.out.println("Объединение множеств:");
        System.out.println(MyCollect.getUnion(setA, setB));
    }

    static void part3(){
        LinkedList<Integer> randList = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            randList.add((int)Math.round(Math.random()*20)-10);
        }
        Collections.sort(randList, Collections.reverseOrder());
        System.out.println(randList);
    }
}
