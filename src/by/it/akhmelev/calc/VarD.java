package by.it.akhmelev.calc;

class VarD extends Var implements IVariable {

    private double value;

    public double getValue() {
        return value;
    }

    VarD(double value) {
        this.value = value;
    }

    VarD(String strValue) {
        fromString(strValue);
    }

    // implementation IVarable

    @Override
    public void fromString(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    // implementation IOperation

    @Override
    public Var add(Var var) throws MathException {
        if (var instanceof VarD)
            return new VarD(this.value + ((VarD) var).value);
        else
            return var.add(this);
    }

    @Override
    public Var sub(Var var) throws MathException {
        if (var instanceof VarD)
            return new VarD(this.value - ((VarD) var).value);
        else
            return super.sub(var);
    }

    @Override
    public Var mul(Var var) throws MathException {
        if (var instanceof VarD)
            return new VarD(this.value * ((VarD) var).value);
        else
            return var.mul(this);
    }

    @Override
    public Var div(Var var) throws MathException {
        if (var instanceof VarD)
            return new VarD(this.value / ((VarD) var).value);
        else
            return super.sub(var);
    }
}
