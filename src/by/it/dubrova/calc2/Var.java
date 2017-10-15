package by.it.dubrova.calc2;

abstract class Var implements IOperation {

    @Override
    public Var add(Var var) {
        new CalcError("Метод не определён");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new CalcError("Метод не определён");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new CalcError("Метод не определён");
        return null;
    }

    @Override
    public Var div(Var var) {
        new CalcError("Метод не определён");
        return null;
    }

}
