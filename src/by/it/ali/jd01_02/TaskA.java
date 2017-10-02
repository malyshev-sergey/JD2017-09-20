package by.it.ali.jd01_02;

public class TaskA {

    static void showMax(int a[]) {
        Integer res = a[0];
        for (Integer i : a) {
            if (res.toString().length() < i.toString().length()) {
                res = i;
            }
        }
        System.out.println("MAX = " + res.toString() + " length = " + res.toString().length());
        //return "MAX=" + res.toString() + " length=" + res.toString().length();
    }

    static String getMin(int a[]) {
        Integer res = a[0];
        for (Integer i : a)
            if (res.toString().length() > i.toString().length()) {
                res = i;
            }
        System.out.println("MIN = " + res.toString() + " length = " + res.toString().length());
        return "MIN=" + res.toString() + " length=" + res.toString().length();
    }

    static double sa(int arr[]) {
        double sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }
        sum = sum / arr.length;
        System.out.print("Числа меньше " + sum + " : ");
        for (int i : arr) {
            if (i < sum) {
                System.out.print(i + " ");
            }
        }
        return sum;
    }

    static boolean SolveTaskA3(Integer value) {
        char ch[] = value.toString().toCharArray();
        for (int i = 0; i < ch.length; i++)
            for (int j = i + 1; j < ch.length; j++)
                if (ch[i] == ch[j]) {return false;}
                return true;
        }
    }
