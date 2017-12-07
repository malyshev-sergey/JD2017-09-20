package by.it.likhanau.jd02_10;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TaskA {
    public static void main(String[] args) {


        GsonBuilder builder = new GsonBuilder().serializeNulls().setPrettyPrinting();
        Gson gson = builder.create();
        POJOClass pojoClass = new POJOClass(7, "Seven");
        String json = gson.toJson(pojoClass);
        System.out.println(json);
        POJOClass pojoClass2 = gson.fromJson(json, POJOClass.class);
        System.out.println("\n\n" + pojoClass2);
    }
}
