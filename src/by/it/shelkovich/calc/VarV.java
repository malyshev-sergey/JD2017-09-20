package by.it.shelkovich.calc;

public class VarV extends Var {
    private double[] value;

    double[] getValue() {
        return value;
    }

    VarV(String value) {
        this(new double[1]);
    }

    VarV(double[] value) {
        this.value = value;
    }

    public VarV add(VarD arg) {//сложение вектора с числом
        return null;
    }

    public VarV add(VarV arg) {//сложение вектора с вектором
        return null;
    }

    public VarV sub(VarD arg) {//разность вектора с числом
        return null;
    }

    public VarV sub(VarV arg) {//разность вектора с вектором
        return null;
    }

    public VarV mul(VarD arg) {//умножение вектора на число
        return null;
    }

    public VarV mul(VarV arg) {//умножение вектора на вектор
        return null;
    }

    public VarV div(VarD arg) {//деление вектора на число
        return null;
    }

    public VarV div(VarV arg) {//деление вектора на вектор
        return null;
    }



    @Override
    public Var add(Var arg) {
        if(arg instanceof VarD) return add((VarD) arg);
        else if (arg instanceof VarV) return add((VarV) arg);
        else return arg.add(this);
    }

    @Override
    public Var sub(Var arg) {
        if(arg instanceof VarD) return sub((VarD) arg);
        else if (arg instanceof VarV) return sub((VarV) arg);
        else return arg.sub(this);
    }

    @Override
    public Var mul(Var arg) {
        if(arg instanceof VarD) return add((VarD) arg);
        else if (arg instanceof VarV) return add((VarV) arg);
        else return arg.add(this);
    }

    @Override
    public Var div(Var arg) {
        if(arg instanceof VarD) return add((VarD) arg);
        else return super.div(arg);
    }
}
