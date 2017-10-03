package by.it.malyshev.jd01_02;

//import java.util.Scanner;

public class TaskC {

//    static String getMyOneLine() {
//        Scanner s = new Scanner(System.in);
//        String line = s.nextLine();
//        return line;
//    }
//
//    static int[] processOneLine(String line) {
//        String[] strMas = line.split(" ");
//        int[] intMas = new int[strMas.length];
//        for (int i = 0; i < intMas.length; i++) {
//            intMas[i] = Integer.parseInt(strMas[i]);
//        }
//        return intMas;
//    }

//    static int[][] get2DArray() {
//        System.out.println("Введите число рядов");
//        int rows = Integer.parseInt(getMyOneLine());
//        int[][] res = new int[rows][];
//        for (int i = 0; i < rows; i++) {
//            String line = getMyOneLine();
//            res[i] = processOneLine(line);
//        }
//        return res;
//    }

    static void print2DArray(int[][] arr) {
        for (int[] r : arr) {
            for (int value : r) {
                System.out.printf("%5d ", value);
            }
            System.out.println();
        }
    }

    static int[][] getRandomDouble2DArray(int rows, int columns, int n) {
        int[][] res = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res[i][j] = (int) (Math.random() * (2 * n + 1) - n);
            }
        }
        return res;
    }


    static int[][] transposeMatrix(int[][] arr) {
        int[][] res = new int[arr[0].length][arr.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = arr[j][i];
            }
        }
        return res;
    }

    static int[][] rotateMatrix(int[][] arr) {
        int[][] res = new int[arr[0].length][arr.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = arr[j][res.length - 1 - i];
            }
        }
        return res;
    }

    static int[][] moveMinTofirstPosition(int[][] arr) {
        int[][] res = new int[arr.length][arr[0].length];
        int min = arr[0][0];
        int minRow = 0;
        int minCol = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (min > arr[i][j]) {
                    min = arr[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }
        for (int i = 0; i < res[0].length; i++) {
            res[0][i] = arr[minRow][i];
        }
        for (int i = 0; i < minRow; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i + 1][j] = arr[i][j];
            }
        }
        for (int i = minRow + 1; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < res.length; i++) {
            int buffer = res[i][minCol];
            for (int j = minCol - 1; j >= 0; j--) {
                res[i][j + 1] = res[i][j];
            }
            res[i][0] = buffer;
        }
        return res;
    }


    static int positiveSum(int[][] arr) {
        if (arr.length == 1) return 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int c1 = 0;
            int c2 = 0;
            int counter = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > 0) {
                    counter++;
                    if (counter == 1) {
                        c1 = j;
                    } else if (counter == 2) {
                        c2 = j;
                        break;
                    }
                }
            }
            for (int j = c1; j <= c2; j++) {
                sum = sum + arr[i][j];
            }
        }
        return sum;
    }


    static int[][] deleteMaxRowCol(int[][] arr) {

        int max = arr[0][0];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (max == arr[i][j]) {
                    counter++;
                }
            }
        }

        int[] maxElementsI = new int[counter];
        int[] maxElementsJ = new int[counter];
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (max == arr[i][j]) {
                    maxElementsI[c] = i;
                    maxElementsJ[c] = j;
                    c++;
                }
            }
        }
        int countUnique = 0;
        int countI = 0;
        int countJ = 0;
        for (int i = 0; i < counter; i++) {
            countUnique++;
            for (int j = i + 1; j < counter; j++) {
                if (maxElementsI[j] == maxElementsI[i]) {
                    countI++;
                    break;
                }
            }
            for (int j = i + 1; j < counter; j++) {
                if (maxElementsJ[j] == maxElementsJ[i]) {
                    countJ++;
                    break;
                }
            }
        }
        int rowsRes = arr.length - countUnique + countI;
        int colRes = arr[0].length - countUnique + countJ;

        countI = 0;
        countJ = 0;
        int[][] res = new int[rowsRes][colRes];
        if (rowsRes == 0 || colRes == 0) {
            return res;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                boolean a = false;
                for (int k = 0; k < counter; k++) {
                    if ((i == maxElementsI[k]) || (j == maxElementsJ[k])) {
                        a = true;
                        break;
                    }
                }
                if (a) {
                } else {
                    res[countI][countJ] = arr[i][j];
                    if (0 == ((countJ + 1) % colRes)) {
                        countI++;
                        countJ = 0;
                    } else {
                        countJ++;
                    }
                }
            }
        }

        return res;
    }

    static int[][] nullsToEnd(int[][] arr) {
        int[][] res = new int[arr.length][arr[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                res[i][j] = arr[i][j];
            }
        }
        if (res.length == 1) return res;

        int counter = 0;
        for (int i = res.length - 1; i >= 0; i--)
            for (int j = res[0].length - 1; j >= 0; j--)
                if (arr[i][j] == 0) counter++;

        for (int m = 0; m < counter; m++) {
            int[][] temp = new int[res.length][res[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    temp[i][j] = res[i][j];
                }
            }

            int endRow = res.length;
            int endCol = res[0].length;

            int nullRow = 0;
            int nullCol = 0;
            for (int i = endRow - 1; i >= 0; i--) {
                for (int j = endCol - 1; j >= 0; j--) {
                    if (temp[i][j] == 0) {
                        nullRow = i;
                        nullCol = j;
                        for (int k = nullRow; k < endRow; k++) {
                            if (k == nullRow) {
                                for (int l = nullCol; l < endCol - 1; l++) {
                                    res[k][l] = temp[k][l + 1];
                                }
                                if (k != endRow - 1) res[k][endCol - 1] = temp[k + 1][0];
                                else res[k][endCol - 1] = 0;
                            } else {
                                for (int l = 0; l < endCol - 1; l++) {
                                    res[k][l] = temp[k][l + 1];
                                }
                                if (k != endRow - 1) res[k][endCol - 1] = temp[k + 1][0];
                                else res[k][endCol - 1] = 0;
                            }
                        }
                    } else {
                        res[i][j] = temp[i][j];
                    }
                }
            }
        }
        return res;
    }


}
