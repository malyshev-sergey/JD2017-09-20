package by.it.mustaphin.jd01_06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB1 {


    void findVowel(String text) {
        Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ][ауоиэяюёеАУОИЭЮЯЁЕ][а-яА-ЯёЁ]*[ауоиэяюёеыАУОИЭЮЯЁЕЫ][^а-яА-ЯёЁ]|[^а-яА-ЯёЁ][ауоиэяюёеАУОИЭЮЯЁЕ][^а-яА-ЯёЁ]");
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> manyWords = new ArrayList<>();
        HashSet<String> uniqueWord = new HashSet<>();
        while (matcher.find()) {
            manyWords.add(matcher.group().trim().toLowerCase());
            uniqueWord.add(matcher.group().trim().toLowerCase());
        }
        for (String word : uniqueWord) {
            int count = 1;
            for (String repeatedWord : manyWords) {
                if (word.equals(repeatedWord)) {
                    count++;
                }
            }
            System.out.printf("%-7s : %-2d\n", word, --count);
        }
    }

}
