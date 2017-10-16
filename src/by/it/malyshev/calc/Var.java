package by.it.malyshev.calc;

abstract class Var implements IOperation {

    @Override
    public Var add(Var var) {
        new CalcError("Сложение невозможно");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new CalcError("Вычитание невозможно");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new CalcError("Умножение невозможно");
        return null;
    }

    @Override
    public Var div(Var var) {
        new CalcError("Деление невозможно");
        return null;
    }

}
