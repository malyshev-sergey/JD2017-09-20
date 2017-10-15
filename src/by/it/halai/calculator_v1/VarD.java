package by.it.halai.calculator_v1;

/**
 * @author Vitaly Halai
 */
class VarD extends Var implements IVariable {

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

    @Override
    public Var add(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value + ((VarD) var).value);
        else
            return var.add(this);

    }

    @Override
    public Var subtraction(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value - ((VarD) var).value);
        else
            return super.subtraction(var);
    }

    @Override
    public Var multiplication(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value * ((VarD) var).value);
        else
            return var.multiplication(this);
    }

    @Override
    public Var division(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value / ((VarD) var).value);
        else
            return super.division(var);
    }

}
