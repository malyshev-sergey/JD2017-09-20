package by.it.malyshev.calc;

abstract class Var implements IOperation {

    @Override
    public Var add(Var var) throws CalcError{
        throw new CalcError("Сложение невозможно");
//        return null;
    }

    @Override
    public Var sub(Var var) throws CalcError{
        throw new CalcError("Вычитание невозможно");
//        return null;
    }

    @Override
    public Var mul(Var var) throws CalcError{
        throw new CalcError("Умножение невозможно");
//        return null;
    }

    @Override
    public Var div(Var var) throws CalcError{
        throw new CalcError("Деление невозможно");
//        return null;
    }

}
