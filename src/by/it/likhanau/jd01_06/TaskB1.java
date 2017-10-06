package by.it.likhanau.jd01_06;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
private static  boolean searchVowels(String word){
    String pattern = "аеёиоуюя";
    pattern = pattern + pattern.toUpperCase();
    char firstLetter = word.charAt(0);
    char lastLetter = word.charAt(word.length() - 1);
   return (pattern.indexOf(firstLetter) > 0 && pattern.indexOf(lastLetter) > 0);
}

    public static void countWordsWithVowelsInTheBeginnigEnding(String text){
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(text);
        int vowelsCounter = 0;
        while (matcher.find()){
            if(searchVowels(matcher.group())){
                vowelsCounter++;
                System.out.print(matcher.group() + " ");
            }
        }
        System.out.println("\nThere are " + vowelsCounter + " words in the poem with vowels in the beginning and in the end.");
    }
}
