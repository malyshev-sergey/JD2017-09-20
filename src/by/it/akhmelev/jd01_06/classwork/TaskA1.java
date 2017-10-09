package by.it.akhmelev.jd01_06.classwork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern p=Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder sb=new StringBuilder(Data.TXT);
        Matcher m=p.matcher(sb);
        while (m.find()){
            sb.setCharAt(m.start()+3,'#');
            if (m.group().length()>6)
                sb.setCharAt(m.start()+6,'#');
//            System.out.println(m.group());
        }
        System.out.println(sb);

    }
}
