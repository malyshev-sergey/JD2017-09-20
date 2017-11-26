package by.it.mustaphin.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TaskA {

    GsonBuilder builder = new GsonBuilder();
    Gson gson;

    public TaskA() {
        builder.serializeNulls();
        builder.setPrettyPrinting();
        gson = builder.create();
    }

    void convert() {
        TestClass testClass1 = new TestClass();
        String json = gson.toJson(testClass1);
        System.out.println(json);
        TestClass testClass2 = gson.fromJson(json, TestClass.class);
        System.out.println("\n\n" + testClass2);
    }

}
