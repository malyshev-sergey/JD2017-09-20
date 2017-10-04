package by.it.shishov.jd01_05;
import static java.lang.Math.*;
/**
 * Created by Сергей on 04.10.2017.
 */
public class TaskB4 {
    static void solveTaskB4() {
        double y = 0;
        for (double x = 1; x <= 8; x++) {
            for (double i = 6; i <= 11; i++) {
                y = y + pow((x+2), ((1.3)*i));
                x++;
            }
        }
        System.out.println("TaskB4 result = " + y);
    }
}
