package by.it.meshchenko.jd02_05;

import by.it.meshchenko.Util.*;

import java.io.IOException;
import java.util.Locale;

public class Runner02_05 {
    public static void main(String[] args) throws IOException{
        // A.
        //  Создать программу, которая может приветствовать пользователя на
        //      трех языках: английском, русском, белорусском. Требуемый язык и
        //      страна должны сообщаться программе в качестве входных параметров.
        //  Если входные параметры отсутствуют, программа должна выдавать сообщение
        //      на английском.
        //  В приветствии должно также быть Ваше имя.

        // B.
        //  Выводилась текущая дата в том же языковом стандарте, что и приветствие.

        // C.
        //  Язык можно было переключать с клавиатуры командами rube en.
        //  Ресурсы нужно создать сначала как текстовые файлы в формате utf-8 и
        //      получить из них файлы .properties утилитой native2ascii. Приведите
        //      использованные при этом командыв текстовомфайлекоманды.txt.
        //  Опционально. Напишите программу на java, которая автоматически генерирует
        //      файлы .properties из текстовых файлов так же как это делает native2ascii.

        // Опционально. Напишите программу на java, которая автоматически генерирует
        // файлы .properties из текстовых файлов так же как это делает native2ascii.
        EmulatorNative2ascii.run("", "message_be_BY.txt");

        while (true) {
            System.out.println("Доступны команды: 'en', 'ru', 'be' или 'end' для выхода: \n");
            String str = Util.getOneLine();
            if (str.toLowerCase().compareTo("end") == 0) return;
            else {
                try {
                    String com = str.trim();
                    if (com.compareToIgnoreCase("en") == 0) {
                        doThis("en", "UK");
                    } else if (com.compareToIgnoreCase("ru") == 0) {
                        doThis("ru", "RU");
                    } else if (com.compareToIgnoreCase("be") == 0) {
                        doThis("be", "BY");
                    } else System.out.println("Неверная команда...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static private void doThis(String land, String country){

        Locale locale = new Locale(land, country);
        ResMan.INSTANCE.setLocale(locale);

        System.out.println(ResMan.INSTANCE.getString(Msg.WELCOM));
        System.out.println(ResMan.INSTANCE.getString(Msg.NAME));
        System.out.println(ResMan.INSTANCE.getString(Msg.HOW_DO_YOU_DO));
        System.out.println(ResMan.INSTANCE.getString(Msg.TEST));
        System.out.println(ResMan.INSTANCE.getDate());
    }
}
