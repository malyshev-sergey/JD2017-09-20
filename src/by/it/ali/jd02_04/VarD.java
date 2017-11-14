package by.it.ali.jd02_04;


public class VarD extends Var implements Str {

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
        else if (x instanceof VarV)
        return new VarV("Здесь происходит сложение числа с вектором");
        else if (x instanceof VarM)
            return new VarM("Здесь происходит сложение числа с матрицей");
        else
            return x.add(this);
    }
    @Override
    public Var sub(Var x){
        if (x instanceof VarD)
            return new VarD(this.value-((VarD) x).value);
        else
            return x.sub(this);
    }
    @Override
    public Var mul(Var x){
        if (x instanceof VarD)
            return new VarD(this.value*((VarD) x).value);
        else if (x instanceof VarV)
            return new VarV("Здесь происходит умножение числа на вектор");
        else if (x instanceof VarM)
            return new VarM("Здесь происходит умножение числа на матрицу");
        else
            return x.mul(this);
    }
    @Override
    public Var div(Var x){
        if (x instanceof VarD)
            return new VarD(this.value/((VarD) x).value);
        else
            return x.div(this);
    }
}
