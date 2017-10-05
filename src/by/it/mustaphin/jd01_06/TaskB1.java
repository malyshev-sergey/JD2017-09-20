package by.it.mustaphin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    void findVowel(String text) {
	Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ][ауоиэяюёеАУОИЭЮЯЮЁЕ][а-яА-ЯёЁ]*[ауоиэяюёеыАУОИЭЮЯЮЁЕЫ][^а-яА-ЯёЁ]|[^а-яА-ЯёЁ][ауоиэяюёеАУОИЭЮЯЮЁЕ][^а-яА-ЯёЁ]");
	Matcher matcher = pattern.matcher(text);
	int count = 0;
	while (matcher.find()) {
	    System.out.printf("%s : %-2d\n", matcher.group(), ++count);
	}
    }

    void findVowel2(String text) {
	String textMas[] = text.split("[^а-яА-ЯёЁ]");
	Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ][ауоиэяюёеАУОИЭЮЯЮЁЕ][а-яА-ЯёЁ]*[ауоиэяюёеыАУОИЭЮЯЮЁЕЫ][^а-яА-ЯёЁ]|[^а-яА-ЯёЁ][ауоиэяюёеАУОИЭЮЯЮЁЕ][^а-яА-ЯёЁ]");
	Matcher matcher = pattern.matcher(text);
	for (int i = 0; i < textMas.length; i++) {
	    if (textMas[i].isEmpty()) {
		continue;
	    }
	    int count = 0;
	    while (matcher.find()) {
		if (matcher.group().equalsIgnoreCase(textMas[i])) {
		    textMas[i] = "";
		}
		System.out.printf("%s : %-2d\n", matcher.group(), ++count);
	    }
	}
    }

}
