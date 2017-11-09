package by.it.shelkovich.jd2_03;

public class Util {
    static int getRandomIntFromRange(int min, int max){
        int delta = max - min;
        return (int)Math.round(Math.random() * delta + min);
    }

    static void sleep(int timeout){
        try{
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
