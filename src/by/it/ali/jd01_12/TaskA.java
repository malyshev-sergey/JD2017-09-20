package by.it.ali.jd01_12;

import java.util.*;

public class TaskA {
   static void solveA1(){
    ArrayList<Integer> pupils = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            pupils.add(i,(int)(Math.random()*10));
        }
        System.out.println("TaskA1");
        System.out.println("Исходные оценки: "+pupils);
        int a=10;
        for (int j = 0; j < a;) {
            if (pupils.get(j) <5)
            {
                pupils.remove(j);
                a--;
            }
            else j++;
        }
        System.out.println("Без неудовлетворительных: "+pupils);
}

    static void solveA3(){
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            p.add(i,-5+(int)(Math.random()*10));
        }
        System.out.println("TaskA3");
        System.out.println("Исходный список: "+p);
        for (int i = 0; i < 10 ; i++) {
            if (p.get(i)>=0){
            p.add(0,p.get(i));
            p.remove(i+1);}
        }
        System.out.println("Отсортированный список: "+p);
    }
}
