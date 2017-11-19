package by.it.malyshev.calc;

abstract class Var implements IOperation {

    static Var getVar(String name) {
        return Depository.variablesCollection.getOrDefault(name, null);
    }

    @Override
    public Var add(Var var) throws CalcError {
        throw new CalcError("Сложение невозможно");
    }

    @Override
    public Var sub(Var var) throws CalcError {
        throw new CalcError("Вычитание невозможно");
    }

    @Override
    public Var mul(Var var) throws CalcError {
        throw new CalcError("Умножение невозможно");
    }

    @Override
    public Var div(Var var) throws CalcError {
        throw new CalcError("Деление невозможно");
    }

    @Override
    public void saveVar(String name) {
        Depository.variablesCollection.put(name, this);
    }


}
