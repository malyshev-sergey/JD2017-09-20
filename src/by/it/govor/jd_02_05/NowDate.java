package by.it.govor.jd_02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


public class NowDate {
    String lang;
    String country;
    NowDate(String lang, String country){
        this.lang=lang;
        this.country=country;
    }
    public void nowDate(){
        if (lang!=null && country!=null) {
            DateFormat date = DateFormat.getDateInstance(DateFormat.FULL,new Locale(lang,country));
            System.out.println(date.format(new Date()));
        }else{
            DateFormat date = DateFormat.getDateInstance(DateFormat.FULL,Locale.US);
            System.out.println(date.format(new Date()));
        }
    }
}
