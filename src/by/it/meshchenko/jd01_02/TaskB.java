package by.it.meshchenko.jd01_02;

/**
 * Created by user on 27.09.2017.
 */
public class TaskB {
    //метод вывода массива ввиде матрицы
    static void strMatrix(int array[]){
        int n;

        //соответствует ли кол-во элементов квадрату натурального числа,
        //если нет, то последняя строка матрицы будет не полная
        if(Math.sqrt(array.length) % 1 == 0) {
            n = (int)Math.sqrt(array.length);
        }
        else {
            n = (int)Math.sqrt(array.length) + 1;
        }

        for(int i = 0; i < array.length; i++){
            System.out.printf("% -5d",array[i]);
            if((i + 1) % n == 0){
                System.out.printf("%n");
            }
        }
    }

    static void quadratic(int array[]){
        double a = array[0], b = array[1], c = array[2];
        double d;
        System.out.println("корни квадратного уравнения:");

        //Находим дискриминант
        d = b * b - 4 * a  * c;
        if(d > 0){ //Уравнение имеет два корня
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.printf("x1 = %-11.5f  x2 = %-11.5f", x1, x2);
        }
        else if (d == 0) { //Уравнение имеет один корень
            double x = (-b) / (2 * a);
            System.out.printf("x = %-11.5f", x);
        }
        else{ // Уравнение имеет два корня, оба комплексные числа
            double real = (-b) / (2 * a);
            double imgr = (Math.sqrt(-d)) / (2 * a);
            ComplexNumber xi1 = new ComplexNumber(real, imgr);
            ComplexNumber xi2 = new ComplexNumber(real, -imgr);
            System.out.printf("x1 = %-16s    x2 = %-16s", xi1.toString(), xi2.toString());
        }
    }
}
