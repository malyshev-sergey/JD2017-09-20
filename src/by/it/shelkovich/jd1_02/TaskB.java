package by.it.shelkovich.jd1_02;

public class TaskB {
    static void part1() {
        System.out.println("Вывод квадратной матрицы:");
        int k = 25;
        for (int i = 1; i <= k; i++) {
            System.out.printf("%-2d ", i);
            if (i % Math.sqrt(k) == 0) System.out.println();
        }
    }

    static void part2() {
        System.out.println("Рассчёт корней квадратного уравнения. Введите параметры a, b и с через пробел:");
        String[] line = Util.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);

        int d = b * b - 4 * a * c;
        if (d < 0) System.out.println("Уравнение не имеет действительных корней");
        else {
            double x1 = (-b + Math.sqrt(d)) / 2 * a;
            double x2 = (-b - Math.sqrt(d)) / 2 * a;
            System.out.printf("Корни уравнения:\n%-3.3f\n%-3.3f \n", x1, x2);
        }
    }

    static void part3() {
        System.out.println("Введите число, соответствующее месяцу (от 1 до 12):");
        String month = Util.readLine().trim();

        switch (month) {
            case "1":
                System.out.println("Январь");
                break;
            case "2":
                System.out.println("Февраль");
                break;
            case "3":
                System.out.println("Март");
                break;
            case "4":
                System.out.println("Апрель");
                break;
            case "5":
                System.out.println("Май");
                break;
            case "6":
                System.out.println("Июнь");
                break;
            case "7":
                System.out.println("Июль");
                break;
            case "8":
                System.out.println("Август");
                break;
            case "9":
                System.out.println("Сентябрь");
                break;
            case "10":
                System.out.println("Октябрь");
                break;
            case "11":
                System.out.println("Ноябрь");
                break;
            case "12":
                System.out.println("Декабрь");
                break;
            default:
                System.out.println("Введённо неверное значение");
        }
    }
}
