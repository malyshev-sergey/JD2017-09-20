package by.it.malyshev.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    static void taskB1() {

        StringBuilder sb = new StringBuilder(RunnerSix.LUKOMOR);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(sb);

        int counter = 0;
        while (m.find()) {

            String vowels = "яыуаиеоюэёЯЫУАИЕОЮЭЁ";
            char firstLetter = m.group().charAt(0);
            char lastLetter = m.group().charAt(m.group().length() - 1);
            boolean ifVowels = (vowels.indexOf(firstLetter) >= 0 && vowels.indexOf(lastLetter) >= 0);

            if (ifVowels) {
                counter++;
//                System.out.println(m.group());
            }

        }
        System.out.println("\nЗадание B1:\n");
        System.out.println("Количество слов, начинающихся и заканчивающихся гласной буквой = " + counter + "\n");

    }

    static void taskB2() {
        System.out.println("\nЗадание B2:\n");

        StringBuilder sb = new StringBuilder(RunnerSix.LUKOMOR);

        Pattern p1 = Pattern.compile("[^\n]+(\n|\\.)");
        Matcher m1 = p1.matcher(sb);
        while (m1.find()){
            sb.setCharAt(m1.start(),m1.group().toLowerCase().charAt(0));
         }

        Pattern p2 = Pattern.compile("\n");
        Matcher m2 = p2.matcher(sb);
        while (m2.find()){
            sb.setCharAt(m2.start(),' ');
        }

        Pattern p = Pattern.compile("([^.!?]|\\.\\.\\.)+([.?!] *)");
        Matcher m = p.matcher(sb);

        int counter = 0;
        while (m.find()) {
            counter++;
        }

        String[] sentences = new String[counter];
        counter = 0;
        m.reset();
        while (m.find()) {
            sb.setCharAt(m.start(),m.group().toUpperCase().charAt(0));
            sentences[counter] = m.group();
            counter++;
        }

        int[] wordsQ = new int[counter];
        for (int i = 0; i < counter; i++) {
            Pattern w = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher word = w.matcher(sentences[i]);
            int counterWords = 0;
            while (word.find()) {
                counterWords++;
            }
            wordsQ[i] = counterWords;
        }

        int min = wordsQ[0];
        for (int i = 0; i < wordsQ.length; i++) {
            if (wordsQ[i] < min) min = wordsQ[i];
        }

        int[] wordsQSorted = Arrays.copyOfRange(wordsQ,0,wordsQ.length);
        Arrays.sort(wordsQSorted);

        for (int i = 0; i < wordsQ.length; i++) {
            for (int j = 0; j < wordsQ.length; j++) {
                if (wordsQSorted[i] == wordsQ[j]) {
                    System.out.println(sentences[j]);
                    wordsQ[j]=min-1;
                }
            }
        }

    }


}


