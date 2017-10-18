package by.it.meshchenko.jd01_12;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class TaskA {
    // A.1  ****************************************************
    public static void exampleA1(){
        List<Student> listStudents = new ArrayList<>(Arrays.asList(
                new Student("Oleg", "M"),
                new Student("Vova", "P"),
                new Student("Sasha", "L"),
                new Student("Kolya", "L"),
                new Student("Dima", "M"),
                new Student("Donald", "T"),
                new Student("Barak", "O")));
        System.out.println("Список учеников:");
        for(Student st : listStudents) {
            System.out.printf("%-10s  %-2s %n", st.getFirstName(), st.getLastName());
        }
        System.out.println("Ученики получили оценки:");
        for(Student st : listStudents) {
            st.setMark(addMark());
            System.out.printf("%-10s  %-2s  %-2d  %n", st.getFirstName(), st.getLastName(), st.getMark());
        }
        System.out.println("Те, чьи оценки удовлетворительные:");
        for(Student st : listStudents) {
            if(st.getMark() > 4) {
                System.out.printf("%-10s  %-2s  %-2d  %n", st.getFirstName(), st.getLastName(), st.getMark());
            }
        }
    }
    private static int addMark(){
        // Оценки 1 - 10 (задаём случ.цичло 0 - 9 и прибавляем 1)
        return Util.randomInt(9) + 1;
    }
    //****************************************************

    // A.2  ****************************************************
    public static void exampleA2(){
        LinkedHashSet<Integer> aHS = new LinkedHashSet<>();
        LinkedHashSet<Integer> bHS = new LinkedHashSet<>();
        aHS.addAll(Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37));
        bHS.addAll(Arrays.asList(1, 2, 3, 5, 8, 13, 21, 34, 55, 89));
        System.out.println("Множество А : " + MyCollect.collectionToString(aHS));
        System.out.println("Множество B : " + MyCollect.collectionToString(bHS));
        System.out.println("Множество A cross B : "
                + MyCollect.collectionToString(MyCollect.getCross(aHS, bHS)));
        System.out.println("Множество A union B : "
                + MyCollect.collectionToString(MyCollect.getUnion(aHS, bHS)));
    }

    public static void exampleA3(){
        Deque<Integer> list = new ArrayDeque<>(Arrays.asList(
                -1, 2, -3, -7, 4, -3,
                3, 10, 22, -9, 0, 10,
                -7, 33, 53, 44, 21, 33));
        System.out.println("Произвольный список чисел: " + MyCollect.collectionToString(list));
        Deque<Integer> newList = new ArrayDeque<>();
        for(Iterator<Integer> i = list.iterator(); i.hasNext();){
            int var = i.next();
            if(var < 0){
                newList.addFirst(var);
            }
            else {
                newList.addLast(var);
            }
        }
        System.out.println("Отрицательные в начале: " + MyCollect.collectionToString(newList));

    }
}

