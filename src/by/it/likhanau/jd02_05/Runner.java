package by.it.likhanau.jd02_05;

import java.io.IOException;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        LanguageChoice choice = new LanguageChoice();
        choice.chooseLanguage();
        ResMng.INSTANCE.SetLocale(choice.locale);
        System.out.println("The locale is "+choice.locale);
        System.out.println(ResMng.INSTANCE.getString("msg.WELCOME"));
        System.out.println(ResMng.INSTANCE.getString("msg.NAME"));
        System.out.println(ResMng.INSTANCE.getString("msg.NICE_TO_MEET_YOU"));
    }
}
