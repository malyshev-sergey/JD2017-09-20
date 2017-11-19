package by.it.malyshev.calc;

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
        return Double.toString(value + 0.0);
    }


    @Override
    public Var add(Var var) throws CalcError {
        if (var instanceof VarD)
            return new VarD(this.value + ((VarD) var).value);
        return var.add(this);
    }

    @Override
    public Var sub(Var var) throws CalcError {
        if (var instanceof VarD)
            return new VarD(this.value - ((VarD) var).value);
        VarD min = new VarD(-1);
        return min.mul(var.sub(this));
    }

    @Override
    public Var mul(Var var) throws CalcError {
        if (var instanceof VarD)
            return new VarD(this.value * ((VarD) var).value);
        else
            return var.mul(this);
    }

    @Override
    public Var div(Var var) throws CalcError {
        if (var instanceof VarD)
            if (((VarD) var).value != 0) return new VarD(this.value / ((VarD) var).value);
            else throw new ArithmeticException("Деление на ноль невозможно");
        else
            return super.div(var);
    }
}

