package by.it.shelkovich.jd1_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    static void part1(){
        Pattern pattern = Pattern.compile(
                "[^А-Яа-яЁе]([аАёЁеЕуУиИюЮяЯыЫэЭоО]([А-Яа-яЁё]*[аАёЁеЕуУиИюЮяЯыЫэЭоО])*)[^А-Яа-яЁе]"
        );
        Matcher matcher = pattern.matcher(Source.sourceText);
        int count = 0;
        while(matcher.find()){
            count++;
            //System.out.println(matcher.group(1));
        }
        System.out.printf("\nКоличество слов, которое начинается и заканчивается гласными: %-3d",count);
    }
    static void part2(){
        System.out.println();
        StringBuilder sb = new StringBuilder(Source.sourceText);
        Pattern pattern = Pattern.compile("\n");
        Matcher matcher = pattern.matcher(sb);
        String[] sentences = matcher.replaceAll(" ").split("(?<!\\.)\\.(?!\\.)|\\!");

        for (int i = 0; i < sentences.length-1; i++) {
            for (int j = i+1; j < sentences.length; j++) {
                if (sentences[i].length() > sentences[j].length()){
                    String s =  sentences[i];
                    sentences[i] = sentences[j];
                    sentences[j] = s;
                }
            }
        }
        for (String s: sentences) {
            System.out.println(s.trim());
        }
    }
}
