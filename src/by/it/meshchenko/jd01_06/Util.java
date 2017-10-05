package by.it.meshchenko.jd01_06;

public class Util {
    static void sortByLengthLines(StringBuilder[] arr){
        int startIndex = 0;
        int endIndex = arr.length - 1;
        doSort1(arr, startIndex, endIndex);
    }

    private static void doSort1(StringBuilder[] arr, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            //int ai = arr[i].length();
            //int ac = arr[cur].length();
            //int aj = arr[j].length();
            while (i < cur && (arr[i].length() <= arr[cur].length())) {
                i++;
            }
            while (j > cur && (arr[cur].length() <= arr[j].length())) {
                j--;
            }
            if (i < j) {
                StringBuilder temp = (arr[i]);
                arr[i] = (arr[j]);
                arr[j] = (temp);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort1(arr, start, cur);
        doSort1(arr, cur +1, end);
    }

    static void quickSort(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        doSort(arr, startIndex, endIndex);
    }

    private static void doSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (arr[i] <= arr[cur])) {
                i++;
            }
            while (j > cur && (arr[cur] <= arr[j])) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(arr, start, cur);
        doSort(arr, cur +1, end);
    }
}
