package by.it.halai.calculator_v2;

/**
 * @author Vitaly Halai
 */
public class Multiplication extends Var implements IOperations {

    public Var multiplication(VarD v1, VarD v2) {
        return new VarD(v1.getValue() * v2.getValue());
    }

    public Var multiplication(VarD v1, VarV v2) {
        VarV result = v2;
        double operand2 = v1.getValue();
        for (int i = 0; i < result.getValue().length; i++)
            result.getValue()[i] *= operand2;
        return result;
    }

    public Var multiplication(VarD v1, VarM v2) {
        new CalcError("Произведение числа и матрицы");
        return null;
    }

    public Var multiplication(VarV v1, VarD v2) {
        return new Multiplication().multiplication(v2, v1);
    }

    public Var multiplication(VarV v1, VarV v2) {
        double sum = 0;
        for (int i = 0; i < v1.getValue().length; i++)
            sum = v1.getValue()[i] + v2.getValue()[i];
        return new VarD(sum);
    }

    public Var multiplication(VarM v1, VarD v2) {
        return new Multiplication().multiplication(v2, v1);
    }

    public Var multiplication(VarM v1, VarV v2) {
        new CalcError("Произведение матрицы и вектора");
        return null;
    }

    public Var multiplication(VarM v1, VarM v2) {
        new CalcError("Произведение матриц");
        return null;
    }
}
