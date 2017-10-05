package by.it.halai.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vitaly Halai
 */
public class TaskB {

    private static boolean searchOfVowel(String word) {
        //паттерн для гласных букв
        String oae = "яыуаиеоюэё";
        //добавим туда еще и большие
        oae = oae + oae.toUpperCase();
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        //вернем true если гласная в начале и в конце
        return (oae.indexOf(first) >= 0 && oae.indexOf(last) >= 0);
    }

    static void solveTaskB1() {
        //паттерн для слов
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");

        StringBuilder sb = new StringBuilder(Data.TXT);

        Matcher m = p.matcher(sb);
        int counter = 0;
        while (m.find()) {
            if (searchOfVowel(m.group())) {
                counter++;
            }
        }
        System.out.printf("Количество слов начинающихся и заканчивающихся гласными буквами равно %d", counter);
    }

    static void solveTaskB2() {
        Pattern p = Pattern.compile("[.!?]");
        String[] sentences = Data.TXT.split(p.pattern());
        System.out.println("Предложения до сортировки");
        for (int i = 0; i < sentences.length; i++) {
            String s = TaskB.getOneLineSentence(sentences[i]);
            sentences[i] = s;
            System.out.println(sentences[i]);
        }
        System.out.println();
        System.out.println("Предложения после сортировки");
        TaskB.sortSentences(sentences);
    }

    private static String getOneLineSentence(String sentence) {
        String[] s = sentence.split("\n");
        String sM = "";
        for (int i = 0; i < s.length; i++) {
            if (i == s.length - 1) {
                sM = sM + s[i] + ".";
            } else {
                sM = sM + s[i] + " ";
            }
        }
        return sM;
    }

    private static void sortSentences(String[] sentences) {
        for (int i = 0; i < sentences.length; i++) {
            for (int j = i + 1; j < sentences.length; j++) {
                String[] s1 = sentences[i].split(" ");
                String[] s2 = sentences[j].split(" ");
                if (s2.length > s1.length) {
                    String s = sentences[i];
                    sentences[i] = sentences[j];
                    sentences[j] = s;
                }
            }
            System.out.println(sentences[i]);
        }

    }
}
