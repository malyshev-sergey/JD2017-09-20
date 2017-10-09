package by.it.dubrova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(Data.lukomor);
        // регулярка на поиск только русских слов
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher m = p.matcher(sb);

        while (m.find()){
            int start = m.start();              // Глобальный индекс всего текста
            int lenght = m.group().length();    //длинна только 1 слова
          //  System.out.print(" " + start + " ");
            sb.setCharAt(start + 3, '#');
            if (lenght > 6)
                sb.setCharAt(start + 6, '#');
        }



        System.out.print(sb);
    }
}
