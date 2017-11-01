package by.it.dubrova.calc2;

public class VarD extends Var implements IVariable {

    private double value;
    public double getValue() {
        return value;
    }
    @Override
    public void fromString(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    public String toString(){
        return Double.toString(this.value);
    }

    VarD(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var var){
        if (var instanceof VarD)
            return new VarD(this.value + ((VarD) var).value);
        else // иначе перегружаем метод
            return var.add(this);
    }
    @Override
    public Var sub(Var var){
        if (var instanceof VarD)
            return new VarD(this.value - ((VarD) var).value);
        else
            return var.add(this);
    }
    @Override
    public Var mul(Var var){
        if (var instanceof VarD)
            return new VarD(this.value * ((VarD) var).value);
        else
            return var.add(this);
    }
    @Override
    public Var div(Var var){
        if (var instanceof VarD)
            return new VarD(this.value / ((VarD) var).value);
        else
            return var.add(this);
    }


}
