package by.it.halai.calculator_v2;

/**
 * @author Vitaly Halai
 */
public class Subtraction extends Var implements IOperations {

    public Var subtraction(VarD v1, VarD v2) {
        return new VarD(v1.getValue() - v2.getValue());
    }

    public Var subtraction(VarV v1, VarD v2) {
        VarV result = v1;
        double operand2 = v2.getValue();
        for (int i = 0; i < result.getValue().length; i++)
            result.getValue()[i] -= operand2;
        return result;
    }

    public Var subtraction(VarV v1, VarV v2) {
        VarV result = v1;
        VarV operand2 = v2;
        for (int i = 0; i < result.getValue().length; i++)
            result.getValue()[i] -= operand2.getValue()[i];
        return result;
    }

    public Var subtraction(VarM v1, VarD v2) {
        new CalcError("Разность матрицы и числа");
        return null;
    }
}
