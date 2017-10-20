package by.it.malyshev.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {

    public static void main(String[] args) {

        int n=50000;

        System.out.println("\nВ кругу стоят "+n+ " человек, пронумерованных от 1 до "+n+". При ведении счета по кругу\n" +
                "вычеркивается каждый второй человек, пока не останется один.");
        Timer t=new Timer();

        processArray(n);
        System.out.println("\nметод processArray моделирующий процесс проработал:  "+t);
        processLinked(n);
        System.out.println("\nметод processLinked моделирующий процесс проработал:  "+t);

    }

    private static void processArray(int n) {
        List<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) a.add(i);
        Iterator<Integer> itr;
        int counter = 0;
        while (a.size() > 1) {
            itr = a.iterator();
            while (itr.hasNext()) {
                itr.next();
                if (counter == 1) itr.remove();
                counter++;
                if (counter > 1) counter = 0;
            }
        }
    }

    private static void processLinked(int n) {
        List<Integer> a = new LinkedList<>();
        for (int i = 0; i < n; i++) a.add(i);
        Iterator<Integer> itr;
        int counter = 0;
        while (a.size() > 1) {
            itr = a.iterator();
            while (itr.hasNext()) {
                itr.next();
                if (counter == 1) itr.remove();
                counter++;
                if (counter > 1) counter = 0;
            }
        }
    }

    public static class Timer {
        private long iniTime;
        private Double Delta;

        Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();

            return Delta.toString() + " микросекунд.";
        }
    }


}
