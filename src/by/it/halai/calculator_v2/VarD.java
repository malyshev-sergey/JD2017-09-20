package by.it.halai.calculator_v2;

/**
 * @author Vitaly Halai
 */
public class VarD extends Var implements IVariable {
    private double value;

    public double getValue() {
        return value;
    }

    @Override
    public void fromString(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    VarD(double value) {
        this.value = value;
    }

    VarD(String strValue) {
        fromString(strValue);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }


}
