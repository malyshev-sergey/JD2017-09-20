package by.it.shelkovich.calc;

public interface IOperator {
    Var add(Var v1, Var v2);
    Var sub(Var v1, Var v2);
    Var mul(Var v1, Var v2);
    Var div(Var v1, Var v2);

}
