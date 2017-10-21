package by.it.shelkovich.jd1_13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskC {
    static void run() {
        RussianRoulette rr = new RussianRoulette();
        List<RiskyGuy> riskyGuys = new ArrayList<>();
        riskyGuys.add(new RiskyGuy("Василий", rr));
        riskyGuys.add(new RiskyGuy("Тимофей", rr));
        riskyGuys.add(new RiskyGuy("Геннадий", rr));

        System.out.println("Игра в русскую рулетку начинается!");
        Iterator<RiskyGuy> iter = riskyGuys.iterator();
        while (iter.hasNext()) {
            RiskyGuy guy = iter.next();
            try {
                guy.attemptRisk();
            } catch (DeadException e) {
                System.err.println("Класс + ошибка: " + e);
                StackTraceElement trace = e.getStackTrace()[0];
                System.err.println("Ошибка возникла в  " + trace.getLineNumber() + " строке класса " + trace.getClassName());
                System.err.println("Глубина вложенности: " + e.getStackTrace().length);
                e.printStackTrace();
                System.err.printf("Ужас, %s погиб!\n", guy.getName());
                iter.remove();
            }
        }
    }

}
