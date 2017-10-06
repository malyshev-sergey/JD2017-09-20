package by.it.biazverkhi.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA1 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Data.Text);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        //  System.out.print(p);
        Matcher m = p.matcher(text);
      //  System.out.println(m);
        while (m.find()) {

            int start = m.start();
            int lenght = m.group().length();
            //System.out.print(" "+start+" "+lenght+" ;");
            // System.out.print(m.group());

            text.setCharAt(start + 3, '#');
            if (lenght > 6) {
                text.setCharAt(start + 6, '#');}

           // System.out.print(m.group());

                // System.out.print(start+" "+lenght+" ;");
            }
        System.out.print(text);

        //}
        }
    }
