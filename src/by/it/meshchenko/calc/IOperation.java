package by.it.meshchenko.calc;

public interface IOperation {
    Var add(Var var);
    Var sub(Var var);
    Var mul(Var var);
    Var div(Var var);
    boolean assign(Var var);
    boolean assign(String str);
}
