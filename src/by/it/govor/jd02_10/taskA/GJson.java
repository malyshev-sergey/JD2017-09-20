package by.it.govor.jd02_10.taskA;

import com.google.gson.GsonBuilder;

public class GJson {

    public static void main(String[] args) {
        com.google.gson.Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        TestClass testClass=new TestClass("Hello world",8,54);

        String json = gson.toJson(testClass);
        System.out.print(json);

        TestClass dev2=gson.fromJson(json, TestClass.class);
        System.out.print("\n\ndev2=" + dev2.toString());
    }
}


