package by.it.halai.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Vitaly Halai
 */
public enum ResMan {

    INSTANCE;
    private ResourceBundle bundle;
    private String Path = "by.it.halai.jd02_05.res.messages";

    ResMan() {
        Locale.setDefault(Locale.ENGLISH);
        bundle = ResourceBundle.getBundle(Path, Locale.getDefault());
    }

    void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(Path, locale);
    }

    String getString(String key) {
        return bundle.getString(key);
    }
}
