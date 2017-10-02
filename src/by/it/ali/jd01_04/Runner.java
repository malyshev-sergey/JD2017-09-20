package by.it.ali.jd01_04;

/**
 * Created by user on 29.09.2017.
 */
public class Runner {
    public static void main(String[] args) {
        TaskA.Tabl();
        int[] a = TaskA.MassKol();
        int[] b = TaskA.FirstLastOrig(a);
        Utils.Sort(a);
        TaskA.FirstLast(a, b);
        TaskB.People();
    }
}
