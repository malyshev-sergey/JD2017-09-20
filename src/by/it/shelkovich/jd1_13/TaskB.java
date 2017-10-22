package by.it.shelkovich.jd1_13;

public class TaskB {
    static void run() throws ArithmeticException, NullPointerException, StringIndexOutOfBoundsException{
        System.out.println("Старт уровня 1");
        try {
            level2();
            int i = (int)Math.round(Math.random());
            String str;
            if (i==0) {
                str = null;
            } else {
                char[] chs = new char[(int)Math.round(Math.random()*10)];
                str = new String(chs);
                str.charAt(7);
            }
        }catch (NullPointerException e){
            System.out.println("Обращение по нулевой ссылке! (уровня 1)");
            throw e;

        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Выход за пределы размеров строки! (уровня 1)");
            throw e;
        }
        System.out.println("Финиш уровня 1");
    }

    static double level2() throws ArithmeticException{
        System.out.println("Старт уровня 2");
        double d = 0;
        try {
            level3();
            d = Math.random()*2-1;
            if (d<0)throw new ArithmeticException();
            d = Math.sqrt(d);
        }catch (ArithmeticException e){
            System.out.println("Произошло извлечение корня из отрицательного числа!  (уровня 2)");
            throw e;
        }
        System.out.println("Финиш уровня 2");
        return d;
    }

    static void level3(){
        System.out.println("Старт уровня 3");
        try {
            long i = 1 / Math.round(Math.random());
        }catch (ArithmeticException e){
            System.out.println("Произошло деление на ноль! (уровня 3)");
        }
        System.out.println("Финиш уровня 3");
    }

}

