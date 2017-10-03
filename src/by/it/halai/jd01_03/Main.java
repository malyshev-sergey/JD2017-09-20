package by.it.halai.jd01_03;


public class Main {
    public static void main(String[] args) {

        //A.1. Реализуйте статические методы ввода-вывода для одномерных и двумерных массивов типа double.
        //Разместите эти методы в классе InOut.

        //Прочитаем строку, заданную с клавиатуры
        System.out.println("Введите элементы одномерного массива");
        String line = InOut.getOneLine();

        //Получим одномерный массив чисел типа double.
        double arr[] = InOut.lineToDoubleArray(line);

        //Выводим одномерный массив на консоль
        InOut.printArray(arr);

        //Зададим размер двумерного массива
        System.out.println("Введите количество строк двумерного массива");
        String strNumber = InOut.getOneLine();
        int number1 = InOut.getNumberOfStr(strNumber);  //получим число строк двумерного массива

        System.out.println("Введите количество столбцов двумерного массива");
        String colNumber = InOut.getOneLine();
        int number2 = InOut.getNumberOfStr(colNumber);  //получим число столбцов двумерного массива

        //Прочитаем строки для заполнения двумерного массива
        double arr2D[][] = InOut.lineToArray2D(number1, number2);

        //Выводим двумерный массив на консоль
        InOut.printArray(arr2D);


        //A.2. Реализуйте статические методы для поиска минимального и максимального значения в одномерном массиве
        //для типа double. Разместите эти методы в классе Util.
        System.out.println("Максимальное значение одномерного массива:");
        Utils.getMaxValue(arr);
        System.out.println("Минимальное значение одномерного массива");
        Utils.getMinValue(arr);


        //В. Реализуйте статические методы для сортировки одномерных массивов типа double.
        //Разместите эти метода в классе Utils.
        System.out.println("Сортировать значения одномерного массива:\n - по возрастанию (введите 1)\n - по убыванию (введите 2)");
        String choice = InOut.getOneLine();                         //прочитаем строку заданную с клавиатуры
        int numberOfChoice = InOut.getNumberOfStr(choice);          //преобразуем строку в число
        double sortsArray[] = Utils.sortArray(arr, numberOfChoice); //сортируем массив по возрастанию\убыванию
        InOut.printArray(sortsArray);                               //Вывод одномерного массива на консоль


        //C. Реализуйте умножение матрицы на вектор, матрицу на матрицу для типа double.
        //Разместите эти метода в классе Utils.


    }
}
