package by.it.dubrova.jd01_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskA {
    public static void main(String[] args) throws IOException {
        /*****Вывести таблицу умножения на экран*****/
        // создадим массив для заполнения его массивом таблицы умножения до 10
        int[][] mt = new int[10][10];
        //клонируем
        mt = createMultiplicationTable(10, 10).clone();
        //делаем вывод на экран, начиная с 2
        for (int i = 2; i < mt.length; i++) {
            for (int j = 2; j < mt[i].length; j++) {
                System.out.printf("%d*%d=%d\t", i, j, mt[i][j]);
            }
            System.out.println();
        }

        /*****Ввод одномерного массива. Вывод одномерного массива в 5 колонок*****/
        System.out.print("Введите строку чисел через пробел и я создам из неё массив: ");
        String line = inputFromKeyboard();
        // ну да, это странно записаноо... а как лучше?
        int array[] = new int[createArrayFromString(line).length];
        array = createArrayFromString(line).clone();
        // вывести массив в 5 колонок - то есть элементов в массиве должно быть <= 5
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (i != array.length) {
                    System.out.printf("array[%d]=%d\t", i, array[i]);
                    i++;
                } else continue;
            }
            System.out.println();
        }

        /*****Отсортировать массив по возрастанию и вывести его в  4 колонки*****/
        //сортировка готовым методом
        Arrays.sort(array);
        System.out.print("\n\n*** after sorting, 4 cols *** \n\n");
        // вывести массив в 4 колонки
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != array.length) {
                    System.out.printf("after_sorting_array[%d]=%d\t", i, array[i]);
                    i++;
                } else continue;
            }
            System.out.println();
        }

        /*****Работа с первым и последним индексом массива*****/
        System.out.printf("Первый индекс %d, последний индекс %d. first + last = %d",array[0],array[array.length-1],array[0]+array[array.length-1] );

    }

    /**
     * @return двумерный массив с таблицей умножения
     * @param x первый множитель
     * @param y второй множитель
     */
    public static int[][] createMultiplicationTable(int x, int y){
        //Создать массив и заполнить
        int[][] mt = new int[x][y];
        for (int i = 0; i < y; i++){ // заполняем x
            //mt[i] = i;
            for (int j = 0; j < x; j++){ // заполняем y
                mt[i][j] = i * j;
            //    вывод таблицы - проще, но не красиво
            //    System.out.printf("%d*%d=%d\t",i, j, mt[i][j]);
            }

        ///    System.out.println();
        }
        return mt;
    }

    /**
     * @return  Строка с консоли
     * @throws IOException  <-- Почему без нее не хочет работать и что это за конструкция???
     */
    private static String inputFromKeyboard() throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        return b.readLine();
    }

    /**
     * @param s Строка (int через пробел)
     * @return массив int, созданный из введённой строки
     */
    private static int[] createArrayFromString(String s){
        String[] tmp = s.split(" ");
        int[] arr = new int[tmp.length];

        for(int i = 0; i < tmp.length; i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }

        return arr;
    }
}
