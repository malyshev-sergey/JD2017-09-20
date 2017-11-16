package by.it.shelkovich.jd2_05;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "by.it.shelkovich.jd2_05.res.messages";
    private ResMan(){
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }
    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }
    public String getString(String key){
        return resourceBundle.getString(key);
    }
}
