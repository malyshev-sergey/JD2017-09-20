package by.it.dubrova.calc;

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
    public Var sub(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value - ((VarD) var).value);
        else
            return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value * ((VarD) var).value);
        else
            return var.mul(this);
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value / ((VarD) var).value);
        else
            return super.sub(var);
    }
}
