package by.it.malyshev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {

    static void taskC1() {

        System.out.println("\nЗадание C1:\n");

        StringBuilder sb = new StringBuilder(RunnerSix.LUKOMOR);
        int sbStartLength = sb.length();

        Pattern p = Pattern.compile("[^\n]+[\n\\.]");
        Matcher m = p.matcher(sb);

        int maxStringLength = 0;
        while (m.find()) {
            if (maxStringLength < m.group().length()) {
                maxStringLength = m.group().length();
            }
        }

        m.reset();
        while (m.find()) {
            StringBuilder a = new StringBuilder(m.group());
            Pattern space = Pattern.compile(" ");
            Matcher mSpace = space.matcher(a);
            for (int i = 0; i < (maxStringLength - m.group().length()); i++) {
                while (!mSpace.find((int) (Math.random() * m.group().length()))) {
                    mSpace.reset();
                }
                a.insert(mSpace.start(), " ");
            }
            sb.append(a.toString());
        }

        sb.delete(0, sbStartLength);
        System.out.println(sb);

    } //taskC1()

    static void taskC2a(int key) {

        System.out.println("\nЗадание C2a: использован класс String\n");

        long start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder(RunnerSix.LUKOMOR);

        String result = "";

        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(sb);

        while (result.length() < key) {

            while (!m.find((int) (Math.random() * sb.length()))) {
                m.reset();
            }
            if (result.length() + m.group().length() + 1 <= key) {
                result += " " + m.group();
                if (result.length() == key - 1) result += " ";
            }
        }

        long time = System.currentTimeMillis() - start;
        long min=time/1000/60;
        long sec=time/1000-min*60;
        System.out.println(min+" min "+sec+" sec " + time%1000+" ms");

    } // taskC2a



    static void taskC2b(int key) {

        System.out.println("\nЗадание C2b: использован класс StringBuilder\n");

        long start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder(RunnerSix.LUKOMOR);

        StringBuilder result = new StringBuilder();
        result.setLength(key);

        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(sb);

        while (result.length() < key) {

            while (!m.find((int) (Math.random() * sb.length()))) {
                m.reset();
            }
            if (result.length() + m.group().length() + 1 <= key) {
                result.append(" " + m.group());
                if (result.length() == key - 1) result.append(" ");
            }
        }

        long time = System.currentTimeMillis() - start;
        long min=time/1000/60;
        long sec=time/1000-min*60;
        System.out.println(min+" min "+sec+" sec " + time%1000+" ms");

    } // taskC2b


} // TaskC
