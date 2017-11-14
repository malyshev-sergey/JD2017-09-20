package by.it.meshchenko.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {

    INSTANCE;
    private Locale locale = Locale.ENGLISH;
    private ResourceBundle bundle;
    private String Path = "by.it.meshchenko.jd02_05.res.message";

    ResMan() {
        Locale.setDefault(locale);
        this.bundle = ResourceBundle.getBundle(Path, Locale.ENGLISH);

    }

    void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle(Path, locale);
        this.locale = locale;
    }

    String getString(String key){
        return bundle.getString(key);
    }

    String getDate() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, this.locale);
        Date d = new Date();
        return df.format(d);
    }
}
