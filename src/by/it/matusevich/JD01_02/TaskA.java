package by.it.matusevich.JD01_02;

public class TaskA {

    public static int getMax(int[] array) {
        Integer max = array [0];
        for (Integer i : array){
            if (max.toString().length() < i.toString().length()){
                max = i;
            }
        }

        return max;
    }

    public static int getMin(int[] numbers) {
        Integer min = numbers [0];
        for (Integer i : numbers){
            if (min.toString().length() > i.toString().length()){
                min = i;
            }
        }

        return min;
    }

    public static int getArifm(int[] intMas) {
        int arifm = 0;
        for (int i : intMas){
            arifm = arifm + i;
        }
        arifm = arifm/intMas.length;
        return arifm;
    }

    public static int getPovtor(int[] intMas) {
    for (int i : intMas) {
        String num = String.valueOf(i);
        char ch[] = num.toCharArray();
        boolean flag = true;
        for (int j = 0; j < ch.length - 1; j++) {
            for (int k = j+1; k < ch.length; k++) {
                if (ch[j] == ch[k]) {
                    flag = false;
                }
            }
        }
        if (flag) return i;

    }
    throw new RuntimeException("No numbers without duplications");

    }
}
