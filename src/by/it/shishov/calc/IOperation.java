package by.it.shishov.calc;

/**
 * Created by Сергей on 11.10.2017.
 */
public interface IOperation {
    Var add(Var var);
    Var sub(Var var);
    Var mul(Var var);
    Var div(Var var);
}
