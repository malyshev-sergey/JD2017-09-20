package by.it.mustaphin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB2 {

    void seekLengthParts(String text) {
	Pattern pat = Pattern.compile("[а-яА-ЯёЁ;: -]+[\\.!]{1,}");
	Matcher mat = pat.matcher(text);
	int part = 0;
	while (mat.find()) {
	    String words[] = mat.group().split("[^а-яА-ЯёЁ]");
	    System.out.println(mat.group());
	    System.out.printf("%-1d : %-3d\n", ++part, words.length);
	}
    }

}
