package by.it.dubrova.calc2;

public class ConsoleRunner {
    public static void main(String[] args) {
        double num1 = 12.5;
        double num2 = 5.5;

        Var a = new VarD(num1);
        Var b = new VarD(num2);

        a = a.sub(b);

        System.out.println(a);
    }
}
