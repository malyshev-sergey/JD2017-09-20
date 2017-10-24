package by.it.meshchenko.jd01_13;

import java.util.ArrayList;

public class TaskB {
    public static void void1(int size) throws Exception {
        System.out.println("void1 START:");
        try{
            void2(size);
            int[] arr = new int[size];
        }
        catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException: При вызове метода использован незаконный аргумент.");
        }
        System.out.println("void1 END");
    }

    private static  void void2(int d){
        System.out.println("void2 START:");
        void3();
        if(d < 0) {
            // Math.sqrt(d) - при d < 0 функция возвращает NAN
            // Геренируем исключение
            throw new IllegalArgumentException();
        }
        System.out.println("void2 END");
    }

    private static  void void3(){
        System.out.println("void3 START:");
        try{
            int a = 2 / 0;
        }
        catch (ArithmeticException e){
            System.out.println("ArithmeticException: Попытка деления на 0.");
        }
        System.out.println("void3 END");
    }
}
