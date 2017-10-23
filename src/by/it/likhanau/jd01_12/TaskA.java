package by.it.likhanau.jd01_12;


import java.util.*;
import java.util.regex.Matcher;

public class TaskA {
    public static void main(String[] args) {

        List<Integer> marksList = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        fullFillTheCollection(marksList);
        fullFillTheCollection(b);
        System.out.println("The student's marks: " + marksList);

        deleteAllValuesUnderFive(marksList);
        System.out.println("Marks bigger than 4: " + marksList);

        marksList.clear();
        fullFillTheCollection(marksList);

        MyCollect.getCross(marksList, b);
        MyCollect.getUnion(marksList, b);

        List<Integer> randomNumList = new LinkedList<>();
        fullFillTheCollectionWithRandomNumbers(randomNumList);
        System.out.println("Collection with random numbers: \n" + randomNumList);
        Collections.sort(randomNumList, Collections.reverseOrder());
        System.out.println("Sorted collection: \n" + randomNumList);
    }

    private static void deleteAllValuesUnderFive(List<Integer> marksList) {
        for (Iterator<Integer> iterator = marksList.iterator(); iterator.hasNext(); ) {
            if(iterator.next() < 5){
                iterator.remove();
            }
        }
    }

    private static void fullFillTheCollection(List<Integer> marksList) {
        for (int i = 0; i < 10; i++) {
            marksList.add(i, (int) (Math.random() * 10 + 1));
        }
    }

    private static void fullFillTheCollectionWithRandomNumbers(List<Integer> list){
        for (int i = 0; i < 10; i++) {
            list.add(i, (int)(Math.random() * 10 - 4));
        }
    }

}
