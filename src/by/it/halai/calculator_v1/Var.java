package by.it.halai.calculator_v1;

/**
 * @author Vitaly Halai
 */
abstract class Var implements IOperation {

    @Override
    public Var add(Var var) {
        new CalculatorError("Сложение невозможно");
        return null;
    }

    @Override
    public Var subtraction(Var var) {
        new CalculatorError("Вычитание невозможно");
        return null;
    }

    @Override
    public Var multiplication(Var var) {
        new CalculatorError("Умножение невозможно");
        return null;
    }

    @Override
    public Var division(Var var) {
        new CalculatorError("Деление невозможно");
        return null;
    }

}
