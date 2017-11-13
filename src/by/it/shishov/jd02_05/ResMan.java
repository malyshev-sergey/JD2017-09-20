package by.it.shishov.jd02_05;

import java.nio.file.Path;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Сергей on 13.11.2017.
 */
public enum ResMan {
    INSTANCE;
    private ResourceBundle bundle;
    private String Path = "by.it.shishov.jd02_05.res.messages";

    ResMan(){
        Locale.setDefault(Locale.ENGLISH);
        bundle = ResourceBundle.getBundle(Path, Locale.getDefault());
    }
    void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle(Path, locale);
    }

    String getString(String key){
        return bundle.getString(key);
    }
}
