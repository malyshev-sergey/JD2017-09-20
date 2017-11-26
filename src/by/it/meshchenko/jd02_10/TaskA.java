package by.it.meshchenko.jd02_10;

import by.it.meshchenko.jd02_09.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TaskA {
    public static void run(){
        //Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        GsonBuilder builder = new GsonBuilder(); //Это строитель
        builder=builder.serializeNulls();        //в нем пишем что сериализуются null
        builder=builder.setPrettyPrinting();     //и вывод будет форматированный
        Gson gson=builder.create();              //теперь строитель строит

        // Создаем объект для тестов
        ShoppingCenters st = new ShoppingCenters() { // анонимный класс
            {
                Rooms roomsZamok = new Rooms();
                Rooms roomsTitan = new Rooms();
                roomsZamok.add(new Room("D32", 540.2, 600, false));
                roomsTitan.add(new Room("R16", 250.8, 500, false));
                ShoppingCenter shC = new ShoppingCenter(
                        "Zamok",
                        new Address("BY", "Minsk", "str.Pobeditelei 65"),
                        56.3,
                        23.6,
                        roomsZamok);
                this.add(shC);
                shC = new ShoppingCenter(
                        "Titan",
                        new Address("BY", "Minsk", "str.Derghinskogo 104"),
                        56.1,
                        23.4,
                        roomsTitan);
                this.add(shC);
            }
        };

        //маршаллизация
        String json = gson.toJson(st, new TypeToken<ShoppingCenters>(){}.getType());
        System.out.print(json);
        //демаршаллизация
        ShoppingCenters st2 = gson.fromJson(json, ShoppingCenters.class);
        System.out.print("\n\nst2=" + st2.toString());
    }
}