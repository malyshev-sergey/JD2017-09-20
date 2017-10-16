package by.it.ali.calc;


abstract class Var implements Func{
    @Override
    public Var add(Var x) {
        System.out.println("Сложение невозможно");
        return null;
    }

    @Override
    public Var sub(Var x) {
        System.out.println("Вычитание невозможно");
        return null;
    }

    @Override
    public Var mul(Var x) {
        System.out.println("Умножение невозможно");
        return null;
    }

    @Override
    public Var div(Var x) {
        System.out.println("Деление невозможно");
        return null;
    }
}