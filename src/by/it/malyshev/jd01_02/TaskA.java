package by.it.malyshev.jd01_02;

public class TaskA {

    private int[] intMas;
    private String strMas;

    public TaskA(String line) {
        String[] strMas = line.split(" ");
        intMas = new int[strMas.length];
        for (int i = 0; i < intMas.length; i++) {
            intMas[i] = Integer.parseInt(strMas[i]);
        }
    }

    //    static void solveTaskA1(String line) {
//        String[] strMas=line.split(" ");
//        int[] intMas=new int[strMas.length];
//        String currentMinValue=line;
//        String currentMaxValue="";
//        for (int i = 0; i < intMas.length; i++) {
//            intMas[i]=Integer.parseInt(strMas[i]);
//            if (strMas[i].length()<currentMinValue.length()) {
//                currentMinValue=strMas[i];
//            }
//            if (strMas[i].length()>currentMaxValue.length()) {
//                currentMaxValue=strMas[i];
//            }
//        }
//
//        System.out.println("MIN="+currentMinValue+" length="+currentMinValue.length());
//        System.out.println("MAX="+currentMaxValue+" length="+currentMaxValue.length());
//
//    }

    //метод поиска самого длинного элемента и его длины
    static String getMax(int array[]) {
        Integer res = array[0];
        for (Integer i : array) {
            if (res.toString().length() < i.toString().length()) {
                res = i;
            }
        }
        return "MAX=" + res.toString() + " length=" + res.toString().length();
    }

    //метод поиска самого короткого элемента и его длины
    static String getMin(int array[]) {
        Integer res = array[0];
        for (Integer i : array) {
            if (res.toString().length() > i.toString().length()) {
                res = i;
            }
        }
        return "MIN=" + res.toString() + " length=" + res.toString().length();
    }

    //метод вычисления среднего арифметического
    static double mean(int array[]) {
        double res = 0;
        for (int i : array) {
            res += i;
        }
        res /= array.length;
        return res;
    }

    //метод поиска числа, состоящего из разных цифр
    static boolean uniqueDigits(Integer value) {
        char ch[] = value.toString().toCharArray();
        for (int i = 0; i < ch.length; i++)
            for (int j = i + 1; j < ch.length; j++)
                if (ch[i] == ch[j]) return false;
        return true;
    }
}
