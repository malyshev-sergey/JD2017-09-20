package by.it.halai.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Vitaly Halai
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Для выбора языка сообщений");
        System.out.println("введите следущее: ");
        System.out.println("en - английский;");
        System.out.println("be - белорусский;");
        System.out.println("ru - русский;");

        String lang = ConsoleScanner.getTheLine();  //преобразуем введенное условное обозначение в строку
        String country = ChoiceOfLanguage.chooseCountry(lang); //выберем строковую переменную страны согласно языку

        Locale locale = new Locale(lang, country); //создадим класс локализации с указанием языка и региона
        ResMan.INSTANCE.setLocale(locale);  //подключаем ресурс локализации
        Date now = new Date();              //создаем класс даты (выуживаем сегодняшнюю дату)
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);  //задаем формат вывода даты на консоль
        System.out.println(df.format(now)); //вывод даты на консоль
        System.out.println(ResMan.INSTANCE.getString(Msg.WELCOME));
        System.out.println(ResMan.INSTANCE.getString(Msg.NAME));
        System.out.println(ResMan.INSTANCE.getString(Msg.HOW_DO_YOU_DO));
        System.out.println(ResMan.INSTANCE.getString(Msg.TEST));

    }
}
