package by.it.halai.calculator_v2;

/**
 * @author Vitaly Halai
 */
public abstract class Var implements IOperations {
    @Override
    public Var add(Var var1, Var var2) {
        new CalcError("Сложение невозможно");
        return null;
    }

    @Override
    public Var subtraction(Var var1, Var var2) {
        new CalcError("Вычитание невозможно");
        return null;
    }

    @Override
    public Var multiplication(Var var1, Var var2) {
        new CalcError("Умножение невозможно");
        return null;
    }

    @Override
    public Var division(Var var1, Var var2) {
        new CalcError("Деление невозможно");
        return null;
    }

}
