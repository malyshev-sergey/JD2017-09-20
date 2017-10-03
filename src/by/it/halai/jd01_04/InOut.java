package by.it.halai.jd01_04;


import java.util.Scanner;

public class InOut {


    //Вывод таблицы умножения на консоль
    static void printTab() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1dx%1d=%2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    //Чтение одной строки
    static String getOneLine() {
        String line = new Scanner(System.in).nextLine();
        return line;
    }

    //Преобразование строки в одномерный массив
    static double[] lineToDoubleArray(String line) {
        String[] strArray = line.split(" ");     //деление строки на элементы массива по пробелам
        double[] array = new double[strArray.length];  //создаем массив нужного типа и размера
        for (int i = 0; i < strArray.length; i++) {        //заполняем полученный массив элементами нужного типа
            array[i] = Double.parseDouble(strArray[i]);
        }
        return array;
    }

    //Вывод на консоль одномерного массива с определенным количеством колонок и именем массива
    static void printArray(double[] array, String name, int cols) {
        int col = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d]= %-4.2f ", i, array[i]);
            col++;
            if ((0 == col % cols) || (array.length - 1 == i)) {
                System.out.println();

            }
        }
        System.out.println();
    }

    //Преобразование строки в одномерный массив строк
    static String[] lineToStringArray(String lineOfSurnames) {
        String[] surnamesArr = lineOfSurnames.split(" ");     //деление строки на элементы массива по пробелам
        return surnamesArr;
    }

    //Создание и заполнения двумерного массива
    static double[][] getZPmass(String[] surnamesArr, int N) {
        int i;
        int j;
        double[][] massZP = new double[surnamesArr.length][4];
        for (i = 0; i < N; i++) {
            System.out.println("Введите выплаты за 4 квартала по квартально для " + surnamesArr[i]);
            String lineOfZP = InOut.getOneLine();   //прочитаем строку введенных выплат с клавиатуры
            double arrZP[] = InOut.lineToDoubleArray(lineOfZP);  //получим одномерный массив выплат
            for (j = 0; j < arrZP.length; j++) {
                massZP[i][j] = arrZP[j];
            }
        }
        return massZP;
    }

    //Вывод на консоль таблицы доходов людей по квартально + за год + общая сумма выплат
    static void printZPTable(String[] surnamesArr, double[][] zP) {
        double sumForOne;
        double sumForAll = 0;
        System.out.printf("%10s %10s %10s %10s %10s %10s \n", "Фамилия", "квартал 1", "квартал 2", "квартал 3", "квартал 4", "Итого");
        System.out.println("-------------------------------------------------------------------");
        for (int i = 0; i < surnamesArr.length; i++) {
            sumForOne = 0;
            System.out.printf("%10s ", surnamesArr[i]);
            for (int j = 0; j < zP[0].length; j++) {

                System.out.printf("%10.2f ", zP[i][j]);
                sumForOne = sumForOne + zP[i][j];
            }
            System.out.printf("%10.2f ", sumForOne);
            System.out.println();
            sumForAll = sumForAll + sumForOne;
        }
        System.out.println();
        System.out.printf("Итого к выплате: %10.2f", sumForAll);

    }

}
