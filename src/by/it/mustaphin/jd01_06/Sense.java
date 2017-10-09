/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.it.mustaphin.jd01_06;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author marat
 */
class Sense {

    String data;
    private List<String> words = new ArrayList<>();

    Sense(String data) {
	this.data = data;
    }

    public int wordsCount() {
	Pattern pat = Pattern.compile("[а-яА-ЯёЁ]+");
	Matcher wordsOnly = pat.matcher(data);
	String words[] = data.split(" ");
	while (wordsOnly.find()) {
	    this.words.add(wordsOnly.group());
	}
	return this.words.size();
    }

}
