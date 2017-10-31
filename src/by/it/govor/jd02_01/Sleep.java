package by.it.govor.jd02_01;


import java.util.Random;

public class Sleep {


    public static void sleep(int start,int end,double speed) {

        Random random = new Random();
        int time = (int)((random.nextInt(end-start)+start)*speed);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void sleep(int time,double speed){
        try {
            Thread.sleep((int)(time*speed));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
