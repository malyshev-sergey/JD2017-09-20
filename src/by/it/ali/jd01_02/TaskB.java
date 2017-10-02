package by.it.ali.jd01_02;

import java.util.Scanner;

public class TaskB {
    static void matriz() {
        System.out.println("Размер матрицы:");
        Scanner in = new Scanner(System.in);
        int raz = in.nextInt();
        int[][] matr = new int[raz][raz];
        int chis = raz * raz;
        System.out.println("Введите " + chis + " чисел для формирования матрицы " + raz + "X" + raz);
        for (int i = 0; i < matr.length; i++)
            for (int j = 0; j < matr[0].length; j++) {
                matr[i][j] = in.nextInt();
                System.out.print(matr[i][j] + " ");
                if (matr.length - 1 == j) {
                    System.out.println();
                }
            }
    }

    static void TaskB2(){
        System.out.println("Введите значения переменных a,b,c квадратного уравнения a*x*x+b*x+c=0");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        double D = b*b-4*a*c;
        double x1=0, x2=0;
        if (D<0)
            System.out.println("Дискриминант <0, корней на множестве действительных чисел нет");
        else if (D==0){
            x1=x2= -(b/(2*a));
            System.out.println("Дискриминант: "+D+" Корни уравнения:"+x1);}
        else {
            x1 = (-b+Math.sqrt(D))/(2*a);
            x2 = (-b-Math.sqrt(D))/(2*a);
            System.out.println("Дискриминант: "+D+" Корни уравнения: x1:"+x1+" x2: "+x2);
            System.out.printf("%-14s%-6.1f%-15s%-7.4f%-5s%-7.4f%n","Дискриминант: ",D," Корни уравнения: x1:",x1," x2: ",x2);
        }
    }

    static void TaskB3()

    {
        System.out.println("Введите число от 1 до 12");
        Scanner in = new Scanner(System.in);
//        try {
        int mes = in.nextInt();
        switch (mes) {
            case 1:
                System.out.println("Январь");
                break;
            case 2:
                System.out.println("Февраль");
                break;
            case 3:
                System.out.println("Март");
                break;
            case 4:
                System.out.println("Апрель");
                break;
            case 5:
                System.out.println("Май");
                break;
            case 6:
                System.out.println("Июнь");
                break;
            case 7:
                System.out.println("Июль");
                break;
            case 8:
                System.out.println("Август");
                break;
            case 9:
                System.out.println("Сентябрь");
                break;
            case 10:
                System.out.println("Октябрь");
                break;
            case 11:
                System.out.println("Ноябрь");
                break;
            case 12:
                System.out.println("Декабрь");
                break;
            default:
                System.out.println("Вы ввели неверное число!");
        }
//        }
//        catch(StackOverflowError e){
//            System.out.println("Исключение:" + e);
//        }
    }
}
