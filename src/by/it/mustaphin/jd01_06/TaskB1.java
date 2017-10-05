package by.it.mustaphin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    void findVowel(String text) {
	Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ][ауоиэяюёеАУОИЭЮЯЮЁЕ][а-яА-ЯёЁ]*[ауоиэяюёеыАУОИЭЮЯЮЁЕЫ][^а-яА-ЯёЁ]");
	Matcher matcher = pattern.matcher(text);
	while (matcher.find()) {
	    System.out.printf("%-8s\n",matcher.group());
	}
    }

}
