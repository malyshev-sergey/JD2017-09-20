package by.it.ali.calc;


public class VarD extends Var implements Str{

    public double value;

    VarD(double value){
        this.value=value;
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var x){
        if (x instanceof VarD)
            return new VarD(this.value+((VarD) x).value);
        else
            return x.add(this);
    }
    @Override
    public Var sub(Var x){
        if (x instanceof VarD)
            return new VarD(this.value-((VarD) x).value);
        else
            return x.add(this);
    }
    @Override
    public Var mul(Var x){
        if (x instanceof VarD)
            return new VarD(this.value*((VarD) x).value);
        else
            return x.add(this);
    }
    @Override
    public Var div(Var x){
        if (x instanceof VarD)
            return new VarD(this.value/((VarD) x).value);
        else
            return x.add(this);
    }
}
