package by.it.shishov.jd01_12;

import java.util.*;

/**
 * Created by Сергей on 23.10.2017.
 */
public class TaskA {
    static ArrayList<Integer> createListOfMarks() {
        ArrayList<Integer> listOfMarks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listOfMarks.add((int) (Math.random() * 10 + 1));
        }
        return listOfMarks;
    }

    static ArrayList<Integer> createListOfNumbers() {
        ArrayList<Integer> listOfMarks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listOfMarks.add((int) (Math.random() * 10 -5));
        }
        return listOfMarks;
    }

    static Set<Integer> createSetOfNumbers() {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            numbers.add((int) (Math.random() *30 - 10));
        }
        return numbers;
    }



    static void printCollection(Collection<Integer> listOfElements) {
        System.out.println(listOfElements);
    }

    static void deleteBadMarks(ArrayList<Integer> listOfMarks) {
        Iterator i = listOfMarks.iterator();
        while (i.hasNext()){
            if ((Integer)i.next() <= 4){
                i.remove();
            }
        }
    }

    static List<Integer> sortCollection(List<Integer> collection){
        Collections.sort(collection, Collections.reverseOrder());
        return collection;
    }
}
