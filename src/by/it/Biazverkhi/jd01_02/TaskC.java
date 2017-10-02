package by.it.Biazverkhi.jd01_02;

class TaskC {
    //создаю матрицу с рандомными числами
    static int[][] Array(int cols_string) {
        int[][] arr = new int[cols_string][cols_string];
        for (int i = 0; i < cols_string; i++) {
            for (int j = 0; j < cols_string; j++) {
                arr[i][j] = (int) (Math.random() * 2000 - 1000);
            }
        }
        return arr;
    }

    // печатаю матрицу
    static void printArray(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                // if (j % cols == 0)
                // System.out.println("");
                System.out.printf("%5d ", array[i][j]);
            }
            System.out.println("");

        }
    }

    //определение суммы двух первых чисел матрицы
    static void sumArray(int array[][]) {
        System.out.println("");

        for (int i = 0; i < array.length; i++) {
            int res = 0;//искомая сумма
            int p = 0;// счетчик двух чисел
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] >= 0) {
                    res += array[i][j];
                    p += 1;
                }
                if (p == 0 && j == array.length - 1) {
                    System.out.printf("строка %d: нет положительного элемента", i);
                    System.out.println("");

                } else if (p == 1 && j == array.length - 1) {
                    System.out.printf("строка %d: всего один положительный элемент:%d", i, res);
                    System.out.println("");

                } else if (p == 2) {
                    System.out.printf("строка %d: сумма двух первых положительных элементов составляет %5d ", i, res);
                    System.out.println("");
                    break;
                }
            }

        }
    }

    //транспонирую матрицу
    static int[][] transArray(int array[][], int cols_string) {
        int transarray[][] = new int[cols_string][cols_string];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                transarray[j][i] = array[i][j];

            }
        }
        return transarray;

    }

    //поворот матрицы на 90 градусов против часовой стрелки
    static int[][] rotArray(int array[][], int cols_string) {
        int rotarray[][] = new int[cols_string][cols_string];
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 0; j <= array.length - 1; j++) {
                rotarray[Math.abs(array.length - 1 - j)][i] = array[i][j];

            }
        }
        return rotarray;

    }

    //печатаю матрицу повернутую на 90 градусов и рядом с ней первоначальную
    static void printArray2(int array[][], int array2[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("%5d ", array[i][j]);
            }
            for (int jj = 0; jj < array2.length; jj++) {
                if (jj == 0) {
                    System.out.printf("      %5d ", array2[i][jj]);
                } else System.out.printf("%5d ", array2[i][jj]);
            }
            System.out.println("");
        }
    }

    //поиск максимального элемента в матрице и удаление строк и столбоцов, его содержащие.
    // Оперирую над повернутой на 90 градусов матрицей.
    static void searchAndDelArray(int array[][], int cols_string) {
        int Max = 0;
        int I = 0;
        int J = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (Max < array[i][j]) {
                    Max = array[i][j];
                    I = i;
                    J = j;
                }
            }
        }
        System.out.println(" ");
        System.out.printf("Максимальный элемент массива найден: MAX[%d,%d]=%d", I, J, Max);
        System.out.println(" ");
        System.out.println("Вывожу массив без заданных строк и столбцов");

// так как не разобрался как передать сразу 3 переменные, печатаю массив тоже тут
        // но при печати удаляю заданные строки и столбцы
        for (int i = 0; i < array.length; i++) {
            if (i == I)
                continue;
            for (int j = 0; j < array.length; j++) {
                if (j == J)
                    continue;
                System.out.printf("%5d ", array[i][j]);
            }
            System.out.println("");

        }


    }


}

