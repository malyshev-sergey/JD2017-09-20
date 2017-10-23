package by.it.shishov.jd01_12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Сергей on 21.10.2017.
 */
public class Runner {
    public static void main(String[] args) {
        //ЗАДАНИЕ А1
        System.out.println("Задание А1. Оценки до:");
        ArrayList<Integer> marks = TaskA.createListOfMarks();
        TaskA.printCollection(marks);
        TaskA.deleteBadMarks(marks);
        System.out.println("Оценки после: ");
        TaskA.printCollection(marks);
        //ЗАДАНИЕ А2
        Set<Integer> set1 = TaskA.createSetOfNumbers();
        System.out.println("Задание А2. Множество А: ");
        TaskA.printCollection(set1);
        Set<Integer> set2 = TaskA.createSetOfNumbers();
        System.out.println("Множество B: ");
        TaskA.printCollection(set2);
        System.out.println("Пересечение множеств :");
        TaskA.printCollection(MyCollect.getCross(set1,set2));
        System.out.println("Объединение множеств");
        TaskA.printCollection(MyCollect.getUnion(set1,set2));
        //ЗАДАНИЕ А3
        System.out.println("Задание А3. Множество до сортировки:");
        List<Integer> list = TaskA.createListOfNumbers();
        TaskA.printCollection(list);
        TaskA.sortCollection(list);
        System.out.println("Множество после сортировки: ");
        TaskA.printCollection(list);


    }
}
