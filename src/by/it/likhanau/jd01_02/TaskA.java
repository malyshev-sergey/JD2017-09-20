package by.it.likhanau.jd01_02;

public class TaskA {

    int[] intArray;
    String[] stringArray;

    public TaskA(String line) {
        stringArray = line.split(" ");
        intArray = new int[stringArray.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
    }

    void searchMaxAndMinLengthNumber(String line) {
        String currentMinValue = line;
        String currentMaxValue = "";
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
            if (stringArray[i].length() < currentMinValue.length()) {
                currentMinValue = stringArray[i];
            }
            if (stringArray[i].length() > currentMaxValue.length()) {
                currentMaxValue = stringArray[i];
            }
        }
        System.out.println("MIN=" + currentMinValue + " length=" + currentMinValue.length());
        System.out.println("MAX=" + currentMaxValue + " length=" + currentMaxValue.length());
    }

    void searchUnderArithmeticalMeanNumbers() {
        double sum = 0;
        for (int value : intArray) {
            sum = sum + value;
        }
        double avg = sum / intArray.length;
        for (int value : intArray) {
            if (value < avg)
                System.out.printf("%d ", value);
        }
        System.out.println();
    }

    void searchNumbersWithDifferentDigits() {
        boolean ok;
        for (Integer value : intArray) {
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
                System.out.printf("Number with different digits = %s%n", str);
                break;
            }
        }

    }

}