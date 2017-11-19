package by.it.govor.jd_02_05;

import sun.security.jca.GetInstance;

import java.util.Locale;
import java.util.ResourceBundle;

public enum  ResMan {
    INSTANCE;
    private ResourceBundle resurs;
    private final String p ="by.it.govor.jd_02_05.text";
    ResMan(){

        resurs = ResourceBundle.getBundle(p, Locale.getDefault());
    }
    void setLocale(Locale locale){

        resurs = ResourceBundle.getBundle(p, locale);
    }
    String getString(String key){
       return resurs.getString(key);
    }
}
