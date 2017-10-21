package by.it.shelkovich.jd1_13;

public class Runner13 {
    public static void main(String[] args) {
        System.out.println("Задание А\n");
        TaskA.run();

        System.out.println("\n\nЗадание B\n");
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

        System.out.println("\n\nЗадание C\n");
        System.out.println("Несколько рискованных парней играют в русскую рулетку, чтобы поднять уровень своей крутизны, но для кого-то из них это может закончиться плохо.");
        TaskC.run();
    }
}
