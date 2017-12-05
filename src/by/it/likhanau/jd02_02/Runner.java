package by.it.likhanau.jd02_02;


import by.it.likhanau.jd02_01.*;
import by.it.likhanau.jd02_01.Manager;

public class Runner {
    public static void main(String[] args) {
        Runnable manager = new by.it.likhanau.jd02_02.Manager();
        Thread thread = new Thread(manager);
        thread.start();
    }
}