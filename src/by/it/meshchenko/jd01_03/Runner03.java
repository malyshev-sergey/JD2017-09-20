package by.it.meshchenko.jd01_03;

import java.io.IOException;

/**
 * Created by user on 27.09.2017.
 */
public class Runner03 {
    public static void main(String[] args) throws IOException {

        //    A. Реализуйте статические методы ввода-вывода для одномерных и
        //двумерных массивов типа double. Разместите эти методы в классе InOut
        double[] arr1 = InOut.createOneMass();
        InOut.printOneMass(arr1);
        double[][] arr2 = InOut.createTwoMass();
        InOut.printTwoMass(arr2);

        //    A. Реализуйте статические методы для поиска минимального и
        //максимального значения в одномерном массиве для типа double. Разместите
        //эти методы в классе Util.
        InOut.printOneMass(arr1);
        System.out.printf("MIN: %-7.3f   ", Util.minInArray(arr1));
        System.out.printf("MAX: %-7.3f %n", Util.maxInArray(arr1));

        //    B. Реализуйте статические методы для сортировки одномерных массивов
        //типа double. Разместите эти методы в классе Util.
        Util.quickSort(arr1);
        InOut.printOneMass(arr1);
        //    C. Реализуйте умножение матрицы на вектор, матрицы на матрицу для типа
        //double. Разместите статические методы в классе Util.
        System.out.println("Умножение двух матриц");
        double[][] m1 = InOut.createTwoMass();
        double[][] m2 = InOut.createTwoMass();
        InOut.printTwoMass(m1);
        InOut.printTwoMass(m2);
        InOut.printTwoMass(Util.MxM(m1, m2));
        //    Реализуйте класс Main или Runner в котором проверьте разработанные
        //        методы (проверьте ввод-вывод одномерных и двухмерных массивов,
        //        проверьте сортировку и поиск минимума/максимума в одномерном массиве,
        //        операции матричного умножения).
        //    Добавьте JavaDoc к разработанным методам

    }
}
