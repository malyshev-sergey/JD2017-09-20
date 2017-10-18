package by.it.mustaphin.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    List<Integer> students = new ArrayList<>(30);

    void fillArray() {
        for (int i = 0; i < 30; i++) {
            students.add((int) (Math.random() * 10) + 1);
        }
    }

    void printMarks() {
        System.out.println("Все оценки");
        for (Integer mark : students) {
            System.out.print(mark + " ");
        }
    }

    void removeBadMarks() {
        Iterator<Integer> itMarks = students.iterator();
        while (itMarks.hasNext()) {
            if (5 > itMarks.next()) {
                itMarks.remove();
            }
        }
        System.out.println("\nХорошие оценки");
        for (Integer mark : students) {
            System.out.print(mark + " ");
        }
    }

}
