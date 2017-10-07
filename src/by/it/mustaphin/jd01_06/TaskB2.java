package by.it.mustaphin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB2 {

    void seekLengthParts(String text) {
	StringBuilder sb = new StringBuilder();
	Pattern patLine = Pattern.compile(".+\n|[а-яА-ЯёЁ ]+[\\.!]{1,}");
	Pattern patPunc = Pattern.compile("[\\.!]{1,}");
	Pattern patWord = Pattern.compile("[^а-яА-ЯёЁ:;,-]");
	Matcher matLine = patLine.matcher(text);
	while (matLine.find()) {
	    sb.append(matLine.group().replace("\n", " "));
	}
	String senses[] = String.valueOf(sb).split(patPunc.pattern());// [\\.!]{1,}
	String words[][] = new String[senses.length][];
	for (int i = 0; i < senses.length; i++) {
	    words[i] = senses[i].split(patWord.pattern());// [^а-яА-ЯёЁ:;-]
	}
	for (int i = words.length - 1; i > 0; i--) {
	    for (int k = 0; k < i; k++) {
		if (words[k].length > words[k + 1].length) {
		    String swap[] = words[k];
		    words[k] = words[k + 1];
		    words[k + 1] = swap;
		}
	    }
	}
	for (int i = 0; i < words.length; i++) {
	    for (int k = 0; k < words[i].length; k++) {
		System.out.printf("%s%d ", words[i][k], k);
	    }
	    System.out.printf("%d\n", words[i].length);
	}
    }
}
