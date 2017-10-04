package by.it.shishov.jd01_06;

import java.util.regex.Pattern;

/**
 * Created by Сергей on 04.10.2017.
 */
public class TaskA2 {
    static void solveTaskA2(){
        Pattern p = Pattern.compile("[^а-яА-ЯёЁ]");
        String[] words = Data.TXT.split(p.pattern());
        int pos = 0;
        while(pos < words.length) {
            if (words[pos].length()>0){
                String word = words[pos];
                int counter = 1;
                for (int i = pos+1; i < words.length; i++) {
                    if(words[i].equals(word)){
                        counter++;
                        words[i] = "";
                    }
                    words[pos] = "";
                }
                System.out.printf("Для слова [%s] число повторов = %d\n", word, counter);
            }
            pos++;
        }
    }


}
