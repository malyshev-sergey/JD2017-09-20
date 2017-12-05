package by.it.likhanau.jd02_05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class LanguageChoice {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Locale locale = Locale.getDefault();
    public Locale chooseLanguage() throws IOException {
        System.out.println("Choose the language, please. Press 1 for Russian, 2 for Belarusian, 3 for English.");
        String number = reader.readLine();

        switch (number) {
            case "1":
                locale = new Locale("ru", "RU");
                break;
            case "2":
                locale = new Locale("be", "BY");
                break;
            case "3":
                locale = new Locale("en","US");
                break;
        }
        return locale;
    }
}
