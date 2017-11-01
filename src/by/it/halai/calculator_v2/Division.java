package by.it.halai.calculator_v2;

/**
 * @author Vitaly Halai
 */
public class Division extends Var implements IOperations {

    public Var division(VarD v1, VarD v2) {
        return new VarD(v1.getValue() / v2.getValue());
    }

    public Var division(VarV v1, VarD v2) {
        VarV result = v1;
        double operand2 = v2.getValue();
        for (int i = 0; i < result.getValue().length; i++)
            result.getValue()[i] /= operand2;
        return result;
    }

    public Var division(VarM v1, VarD v2) {
        new CalcError("Деление матрицы на число");
        return null;
    }
}
