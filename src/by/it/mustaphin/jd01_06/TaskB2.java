package by.it.mustaphin.jd01_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB2 {

    void seekLengthParts(String text) {
        String textMas[] = text.split("[\\.!]{1,}");
        Pattern pat = Pattern.compile("[^а-яА-ЯёЁ]");
        Matcher mat = pat.matcher(text);
        while (mat.find()) {
            System.out.println(mat.start() + " : " + mat.end());
        }
    }

    void seekLengthParts2(String text) {
        String textMas[] = text.split("[\\.!]{1,}");
        int lengthMas[] = new int[textMas.length];
        Map<Integer, List<String>> allParts = new HashMap<>();
        int numb = 1;
        for (String textPart : textMas) {
            String[] innerMas = textPart.split("[^а-яА-ЯёЁ]");
            List<String> listWords = new ArrayList<>();
            for (String singleWord : innerMas) {
                listWords.add(singleWord);
            }
            allParts.put(numb++, listWords);
        }
        int placeNumb = 0;
        for (Map.Entry<Integer, List<String>> entry : allParts.entrySet()) {
            lengthMas[placeNumb] = entry.getValue().size();
            placeNumb++;
        }
    }

}
