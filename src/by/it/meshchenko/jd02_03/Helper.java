package by.it.meshchenko.jd02_03;

public class Helper {
    static int  random(int from, int to){
        return (int)(Math.random() * (to - from) + from);
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
