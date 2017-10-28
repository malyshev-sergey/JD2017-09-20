package by.it.shishov.jd02_01;

/**
 * Created by Сергей on 27.10.2017.
 */
public class Helper {

    static int random(int from, int to){
        return (int)Math.round((Math.random()*(to-from)+ from));
    }
}
