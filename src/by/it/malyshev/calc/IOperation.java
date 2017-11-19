package by.it.malyshev.calc;

interface IOperation {
    Var add(Var var) throws CalcError;

    Var sub(Var var) throws CalcError;

    Var mul(Var var) throws CalcError;

    Var div(Var var) throws CalcError;

    void saveVar(String name);
}
