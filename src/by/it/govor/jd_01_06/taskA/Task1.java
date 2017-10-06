package by.it.govor.jd_01_06.taskA;

//import by.it.govor.jd_01_06.Date;

import by.it.govor.jd_01_06.Date;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 04.10.2017.
 */
public class Task1 {
    protected static void task1() {
        String string= ("[А-яёЁ]{4,}");
StringBuilder b = new StringBuilder(Date.STR);
        Pattern p =Pattern.compile(string);
        Matcher mat = p.matcher(b);
        while(mat.find()){
int start= mat.start();
            int length = mat.group().length();
            if (length>=4){
            b.setCharAt(start+3,'#');
            }
            if(length>=7){
                b.setCharAt(start+6,'*');
            }
        }
        System.out.println(b);
    }
}
