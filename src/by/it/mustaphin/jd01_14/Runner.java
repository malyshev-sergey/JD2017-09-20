package by.it.mustaphin.jd01_14;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
//        new TaskA().write();
//        new TaskA().read();
//
//        new TaskB().count();

        new TaskC().getInfo(new File(System.getProperty("user.dir") + "/src/by/it/mustaphin/"));
    }
}
