package by.it.akhmelev.calc;

interface IOperation {
    Var add(Var var) throws MathException;
    Var sub(Var var) throws MathException;
    Var mul(Var var) throws MathException;
    Var div(Var var) throws MathException;
}
