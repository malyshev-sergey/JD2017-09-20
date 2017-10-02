package by.it.shelkovich.jd1_02;

class TaskA {
    private int[] intArr;
    private String[] strArr;

    TaskA(String srcStr) {
        strArr = srcStr.split(" ");

        intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
    }


    void printLongestShortest() {
        int longest = 0, shortest = 0;
        for (int i = 1; i < intArr.length; i++) {
            if (strArr[longest].length() < strArr[i].length()) longest = i;
            if (strArr[shortest].length() > strArr[i].length()) shortest = i;
        }
        System.out.println("Longest: " + strArr[longest]);
        System.out.println("Shortest: " + strArr[shortest]);
    }

    void printLessThanAverage() {
        int average = 0;
        for (int i = 0; i < intArr.length; i++) {
            average += intArr[i];
        }

        average = average / intArr.length;
        System.out.println("Average: " + String.valueOf(average));

        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] < average) System.out.println(String.valueOf(intArr[i]) + " less than average");
        }
    }

    void printDiffDigitNumber() {
        for (int i = 0; i < intArr.length; i++) {
            if (isAllDigitsUnique(intArr[i])) {
                System.out.println("Contains only unique digits: " + strArr[i]);
                break;
            }
        }
    }

    private boolean isAllDigitsUnique(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
