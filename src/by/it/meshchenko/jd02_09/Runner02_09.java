package by.it.meshchenko.jd02_09;

import by.it.meshchenko.jd02_09.TaskA.TaskA;
import by.it.meshchenko.jd02_09.TaskB.JAXB_fromXML;
import by.it.meshchenko.jd02_09.TaskB.JAXB_toXML;

public class Runner02_09 {
    public static void main(String[] args) {
        // А.
        //  Выполните преобразование XML в HTML файл с таблицей, в которой каждая отдельная
        //  строка это одна из повторяющихся сущностей XML.
        //  (используйте свой XML-файл без схемы и DTD из предыдущих заданий "jd02-07").

        // B.
        //  Создайте набор Java beans классов для маршализации-демаршализации в/из XML с
        //  помощью JAXB. Добавьте необходимые аннотации, конструкторы и методы toString.

        // C.
        //  Повторите задание B использую автоматическую генерациюкода по XSD-схеме.

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

        final String root="src/by/it/meshchenko/";
        final String XML_PATH = "jd02_09/ShoppingCenters.xml";

        System.out.println("A.");
        //TaskA.run(root, XML_PATH);
        System.out.println("\nB.");
        JAXB_fromXML.run(root + XML_PATH);
        JAXB_toXML.run(root);
        System.out.println("\nC.");
        //RP_DOM.parse(XML_PATH);
    }
}
