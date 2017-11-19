package by.it.govor.jd02_02;
import java.util.Random;

public class NewRandom {
    public static int random(int start,int end) {
        Random random = new Random();
        int result = (random.nextInt(end-start)+start);
        return result;
    }
}
