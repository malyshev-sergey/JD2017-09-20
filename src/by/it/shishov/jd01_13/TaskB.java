package by.it.shishov.jd01_13;

/**
 * Created by Сергей on 28.10.2017.
 */
public class TaskB {
    static void catchExceptions() throws ArithmeticException, IndexOutOfBoundsException, NumberFormatException{
        System.out.println("Начало 1 уровня");
        try {
            level2();
            int[] numbers = new int[3];
            numbers[5] = 11;
            String s = "fgf";
            Double a = Double.parseDouble(s);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Обращение к несуществующему индексу массива (уровень 1)");
            throw e;

        }catch (NumberFormatException e){
            System.out.println("Выход за пределы размеров строки! (уровня 1)");
            throw e;
        }
        System.out.println("Финиш уровня 1");
    }

    static void level2() throws ArithmeticException{
        System.out.println("Начало 2 уровня");
        double number = -5;
        try {
            level3();
            if(number < 0)
                throw new ArithmeticException();
            Math.sqrt(number);
        }catch (ArithmeticException e){
            System.out.println("Извлечение корня из отрицательного числа  (уровень 2)");
            throw e;
        }
        System.out.println("Конец 2 уровня");
    }

    static void level3(){
        System.out.println("Начало 3 уровня");
        try{
            int i = 9 /0 ;
        }
        catch (ArithmeticException e)
        {
            System.out.println("Деление на ноль   (уровень 3)");
        }
        System.out.println("Конец 3 уровня");
    }
}
