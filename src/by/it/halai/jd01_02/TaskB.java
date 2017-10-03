package by.it.halai.jd01_02;


class TaskB {

    static void getArray(int k) {
        //определяем число N
        int N = (int) Math.sqrt(k);
        int[][] mas = new int[N][N];
        //заполним массив значениями от 1 до k
        int x = 1;
        for (int i = 0; i <= N - 1; i++) {
            for (int j = 0; j <= N - 1; j++) {
                mas[i][j] = x;
                x = x + 1;
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Поиск корней квадратного уравнения
    static String getX12(double a, double b, double c) {
        //Вычислим дискриминант
        double D = b * b - 4 * a * c;

        //вычислим собсно корни квадратного уравнения
        if (D > 0) {
            double x1 = (-b - Math.sqrt(D)) / (2 * a);
            double x2 = (-b + Math.sqrt(D)) / (2 * a);
            return ("Корни уравнения: Х1 = " + x1 + ", Х2 = " + x2);
        } else if (D == 0) {
            double x = -b / (2 * a);
            return ("Единственный корень уравнения: Х= " + x);
        } else {
            return ("Дискриминант меньше нуля. Уравнение не имеет действительных корней");
        }
    }


    //Сопоставление введенного числа с названием месяца года и проверка на корректность введеного числа
    static String getNameOfMonth(int inNumber) {
        switch (inNumber) {
            case (1): {
                return "Январь";
            }
            case (2): {
                return "Февраль";
            }
            case (3): {
                return "Март";
            }
            case (4): {
                return "Апрель";
            }
            case (5): {
                return "Май";
            }
            case (6): {
                return "Июнь";
            }
            case (7): {
                return "Июль";
            }
            case (8): {
                return "Август";
            }
            case (9): {
                return "Сентябрь";
            }
            case (10): {
                return "Октябрь";
            }
            case (11): {
                return "Ноябрь";
            }
            case (12): {
                return "Декабрь";
            }
            default: {
                return "Введено неверное число";
            }
        }
    }
}
