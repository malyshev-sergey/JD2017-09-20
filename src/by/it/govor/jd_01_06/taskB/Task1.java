package by.it.govor.jd_01_06.taskB;

import by.it.govor.jd_01_06.Date;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static boolean taskDop(String text) {
        String s ="яыуаиеоюэё";
        s+=s.toUpperCase();
        char first=text.charAt(0);
        char last=text.charAt(text.length()-1);
        boolean n =(s.indexOf(first)>=0 && s.indexOf(last)>=0);
        return n;
    }

    public static void task1() {
        StringBuilder s = new StringBuilder(Date.STR);
        Pattern p =Pattern.compile("[А-яёЁ]+");
        Matcher m =p.matcher(s);
        int cout =0;
        while (m.find()){
            if (taskDop(m.group())){
                System.out.println(m.group());
                cout++;
            }
        }
        System.out.println(cout);
    }
}
