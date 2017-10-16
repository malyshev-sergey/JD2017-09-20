package by.it.shishov.calc;

/**
 * Created by Сергей on 11.10.2017.
 */
public class VarD extends Var implements IVariable{
    private double value;
    public double getValue() {
        return value;
    }
    VarD(String strValue) {
        fromString(strValue);
    }
    VarD(double value) {
        this.value = value;
    }

    @Override
    public void fromString(String value){
        this.value = Double.parseDouble(value);

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
