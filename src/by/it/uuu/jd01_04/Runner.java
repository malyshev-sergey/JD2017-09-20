package by.it.uuu.jd01_04;
import java.io.IOException;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) throws IOException {
//делаю таблицу умножения
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {System.out.printf("%1d*%1d=%-2d ", i, j, i * j);}
            System.out.println(""); }
            System.out.println("");
        System.out.println("Введите строку чисел");
        String line = InOut.getOneLine();//ввожу строку данных (числа)
        int arr[] = Utils.lineToIntArray(line);//помещаю введенную и обработанную строку в массив
//объявляю переменные для 1 и последней позиций элеметов в массиве
        int a = arr[0];// значение 1-го элемента массива
        int lastIndex = arr.length - 1;//номер последнего элемента массива
        //int b = arr[lastIndex];    //значение последнего элемента массива в простом виде
        int b = arr[arr.length - 1];// значение последнего элемента массива в сложном виде
//проверка для понимания, что в памяти, печатаю двумя способами:
        System.out.println("");
        System.out.println("arr[0]=" + a + "; позиция последнего элемета=" + lastIndex + "; значение последнего элемента=" + b);
        System.out.printf("arr[0]=%d; позиция последнего элемета=%d; значение последнего элемента=%d", a, lastIndex, b);
        System.out.println("");
        System.out.println(Arrays.toString(arr));//печатаю введенную строку в виде массива для проверки
        System.out.print("Печать несортированного массива в 5 колонок");//вызываю на печать массив с именем V и в 5 колонок
        InOut.printArray(arr, 5);
        System.out.println("");
        Utils.sortArray(arr, true);//сортирую массив по возрастанию
        System.out.print("Печать сортированного массива в 4 колоноки");
        Utils.sortArray(arr, false);//сортирую массив по возрастанию
        System.out.print("Печать сортированного массива в 4 колоноки");
        InOut.printArray(arr, 4);//печатаю сортированный массив в 4 колонки
        System.out.println("");
        System.out.println("");
        int x = Arrays.binarySearch(arr, a);//поиск новой позиции 1 элемента после сортировки из первоначального массива
        System.out.print("новая позиция первого элемента " + a + " = " + x);
        System.out.println("");
        int r = Arrays.binarySearch(arr, b);//поиск новой позиции последнего элемента после сортировки из первоначального массива
        System.out.print("новая позиция последнего элемента " + b + " = " + r);

    }
}
