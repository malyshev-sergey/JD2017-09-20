package by.it.ali.jd01_04;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by user on 29.09.2017.
 */
public class TaskA {
    static void Tabl() {
        int[] a = {2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++) {
                //System.out.print(a[i] + "*" + a[j] + "=" + a[i] * a[j]+" ");
                System.out.printf("%1d*%1d=%2d ",a[i],a[j],a[i]*a[j]);
                if (a.length - 1 == j) {
                    System.out.println();
                }
            }
        System.out.println();
    }

    public static int[] MassKol(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите массив: ");
        String line = in.nextLine();
        String[] masStr = line.split(" ");
        int count = masStr.length;
        int[] a = new int[count];
        for (int i=0; i<count;i++){
            a[i]= Integer.parseInt(masStr[i]);
        }
        int col=0;
        for (int i=0; i<a.length; i++)
        {
            System.out.printf("[%-1d]=%-2d", i, a[i]);
            col++;
            if (0==col%5){System.out.println();}
        }
        System.out.println();
        return a;
    }
     public static int[] FirstLastOrig(int[] a){
         int[] ind = new int [2];
         ind[1]=a[a.length-1];
         ind[0]=a[0];
         System.out.println(ind[0]+" "+ind[1]);
         return ind;
     }

    static void FirstLast(int[] a, int[] ind){
        System.out.println("First-Last:");
        int col=0, indLast=0, indFirst=0, i;
        for (i=0; i<a.length; i++) {
            if (a[i] == ind[0])
                indFirst=i;
            if (a[i] == ind[1])
                indLast=i;
        }
        System.out.println("Индекс 1-ого элемента исходного массива: "+indFirst+" Последнего: "+indLast);
    }
}