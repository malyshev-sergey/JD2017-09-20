package by.it.meshchenko.jd02_08;

public class Runner02_08 {
    public static void main(String[] args) {
        //  C.
        //  Реализуйте три технологии парсинга: SAX StAX DOM.
        //      Во всех трех случаях выводите атрибуты. XML на экране должен быть
        //      читабелен и одинаков для всех трех примеров.

        // Принимаю следующую предметную область Rented Premises:
        // Помещения, которые здаются в аренду (помещения для торговли, первоначально
        // рассматривает в торговых центрах)
        // Таким образом:
        //  ShoppingCenter - торговый центр, где сдаётся помещение
        //      Name - название
        //      Adress - адрес
        //      Lat - координаты широты (для Google карт)
        //      Lng - координаты долготы (для Google карт)
        //  Room - помещение сдаваемое в аренду
        //      RoomName - номер помещения в ТЦ
        //      Square - площадь помещения
        //      Price - стоимость в месяц
        //      isRented - tru если помещение арендовано

        // Соответственно будут RP_SAX, RP_StAX, RP_DOM парсер

        final String XML_PATH = "src/by/it/meshchenko/jd02_07/ShoppingCenters.xml";
        System.out.println("SAX *************************");
        RP_SAX.parse(XML_PATH);
        System.out.println("\nStAX *************************");
        RP_StAX.parse(XML_PATH);
        System.out.println("\nDOM *************************");
        RP_DOM.parse(XML_PATH);
    }
}
