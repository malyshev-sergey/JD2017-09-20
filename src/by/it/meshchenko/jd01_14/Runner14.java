package by.it.meshchenko.jd01_14;

import java.io.IOException;

public class Runner14 {
    public static void main(String[] args) throws IOException {
        // A. Записать в двоичный файл 20 случайных чисел. Прочитать
        //   записанный файл, распечатать числа и их среднее арифметическое.
        System.out.println("A.  **************************");
        TaskA.example1();

        // B. В файле с текстом подсчитать в тексте количество знаков препинания и слов.
        System.out.println("B.  **************************");
        TaskB.example1();

        // C. Вывести список файлов и каталогов каталога проекта
        //    на диске. Файлы и каталоги должны быть распечатаны отдельно.
        System.out.println("C.  **************************");
        TaskC.example1();
    }
}
