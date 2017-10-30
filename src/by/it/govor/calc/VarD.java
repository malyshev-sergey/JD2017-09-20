package by.it.govor.calc;

/**
 * Created by User on 15.10.2017.
 */
class VarD extends Var implements IVariable {
    private double value;
    public String toString() {
        return Double.toString(value);
    }

    public double getValue() {
        return value;}


    public void fromString(String value) {
        this.value = Double.parseDouble(value);
    }

    VarD(double d) {
        this.value = d;
    }

    VarD(String s) {
        this.fromString(s);
    }

    public Var add(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value + ((VarD) var).value);
        else
            return var.add(this);
    }

    public Var sub(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value - ((VarD) var).value);
        else
            return super.sub(var);
    }

    public Var mul(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value * ((VarD) var).value);
        else
            return var.add(this);
    }

    public Var div(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value / ((VarD) var).value);
        else
            return var.add(this);
    }
}
