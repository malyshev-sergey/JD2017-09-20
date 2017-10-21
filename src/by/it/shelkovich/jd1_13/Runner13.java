package by.it.shelkovich.jd1_13;

public class Runner13 {
    public static void main(String[] args) {
        //TaskA.run();

        System.out.println("Старт уровня 0");
        try {
            TaskB.run();
        }catch (ArithmeticException e) {
            System.out.println("Уровень 0 зафиксировал возникновение необработанной арифметической ошибки");
        }catch (NullPointerException e){
            System.out.println("Уровень 0 зафиксировал возникновение необработанной ошибки обращения по нулевой ссылке");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Уровень 0 зафиксировал возникновение необработанной ошибки выхода за пределы строки");
        }
        System.out.println("Финиш уровня 0");
    }
}
