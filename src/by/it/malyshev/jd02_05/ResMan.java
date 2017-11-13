package by.it.malyshev.jd02_05;

import java.text.DateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private ResourceBundle bundle;
    private DateFormat df;
    private  String Path="by.it.malyshev.jd02_05.res.messages";

    ResMan() {
        Locale.setDefault(Locale.ENGLISH);
        bundle=ResourceBundle.getBundle(Path, Locale.ENGLISH);
        df=DateFormat.getDateInstance(DateFormat.FULL,Locale.ENGLISH);
    }

    void setLocale(Locale locale) {
        bundle=ResourceBundle.getBundle(Path, locale);
        df=DateFormat.getDateInstance(DateFormat.FULL, locale);
    }

    String getString (String key) {
        return  bundle.getString(key);
    }

    DateFormat getDateFormat() {return df;}
}
