package by.it.akhmelev.jd01_02.classwork;

public class TaskA {

    private int[] intMas;
    private String[] strMas;

    public TaskA(String line) {
        strMas = line.split(" ");
        intMas = new int[strMas.length];
        for (int i = 0; i < intMas.length; i++) {
            intMas[i] = Integer.parseInt(strMas[i]);
        }
    }

    void solveTaskA1(String line) {
        String currentMinValue = line;
        String currentMaxValue = "";
        for (int i = 0; i < intMas.length; i++) {
            intMas[i] = Integer.parseInt(strMas[i]);
            if (strMas[i].length() < currentMinValue.length()) {
                currentMinValue = strMas[i];
            }
            if (strMas[i].length() > currentMaxValue.length()) {
                currentMaxValue = strMas[i];
            }
        }

        System.out.println("MIN=" + currentMinValue + " length=" + currentMinValue.length());
        System.out.println("MAX=" + currentMaxValue + " length=" + currentMaxValue.length());
    }

    void solveTaskA2() {
        double sum = 0;
        for (int value : intMas) {
            sum = sum + value;
        }
        double avg = sum / intMas.length;
        for (int value : intMas) {
            if (value < avg)
                System.out.printf("%d ", value);
        }
        System.out.println();
    }

    void SolveTaskA3() {
        boolean ok;
        for (Integer value : intMas) {
            String str = value.toString();
            ok = true;
            char[] masChar = str.toCharArray();
            for (int i = 0; i < masChar.length - 1; i++) {
                for (int j = i + 1; j < masChar.length; j++) {
                    if (masChar[i] == masChar[j]) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                System.out.printf("Число из разных цифр = %s%n",str);
                break;
            }
        }

    }

}
