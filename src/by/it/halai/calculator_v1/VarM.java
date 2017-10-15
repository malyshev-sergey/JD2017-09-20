package by.it.halai.calculator_v1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vitaly Halai
 */
class VarM extends Var implements IVariable {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    @Override
    public void fromString(String strMatrix) {

        Pattern p = Pattern.compile(Patterns.exVal);
        value = new double[strMatrix.split(",").length][strMatrix.split(",").length];
        Matcher m = p.matcher(strMatrix);
        int i = 0;
        while (m.find())
            value[i++][i++] = Double.parseDouble(m.group());

    }

    VarM(double[][] value) {
        this.value = value;
    }

    VarM(String strMatrix) {
        fromString(strMatrix);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                if (j == value[i].length - 1) delimiter = "},{";
                else delimiter = ",";
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    // impl IVarable

    @Override
    public Var add(Var var) {
        VarM result;
        if (var instanceof VarD) {
            result = new VarM(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                for (int j = 0; j < value[0].length; j++)
                    result.value[i][j] += operand2;
            return result;
        } else if (var instanceof VarM) {
            new CalculatorError("Сумма матриц");
            return null;
        } else
            return super.add(var);
    }

    @Override
    public Var subtraction(Var var) {
        VarM result;
        if (var instanceof VarD) {
            result = new VarM(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                for (int j = 0; j < value[0].length; j++)
                    result.value[i][j] -= operand2;
            return result;
        } else
            return super.add(var);
    }

    @Override
    public Var multiplication(Var var) {
        VarM result;
        if (var instanceof VarD) {
            result = new VarM(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                for (int j = 0; j < value[0].length; j++)
                    result.value[i][j] *= operand2;
            return result;
        } else if (var instanceof VarV) {
            new CalculatorError("Произведение матрицы на вектор");
            return null;
        } else if (var instanceof VarM) {
            new CalculatorError("Произведение матриц");
            return null;
        } else
            return super.add(var);
    }

    @Override
    public Var division(Var var) {
        VarM result;
        if (var instanceof VarD) {
            result = new VarM(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                for (int j = 0; j < value[0].length; j++)
                    result.value[i][j] /= operand2;
            return result;
        } else
            return super.add(var);
    }
}
