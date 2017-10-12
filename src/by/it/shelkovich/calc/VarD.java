package by.it.shelkovich.calc;

public class VarD extends Var{
    private Double value;

    double getValue(){
        return value;
    }

    VarD(String value) {
        this(Double.parseDouble(value));
    }
    VarD(double value) {
        this.value = value;
    }


    public VarD add(VarD arg) {//Сложение даблов
        return new VarD(value + arg.getValue());
    }

    public VarD sub(VarD arg) {//Разность даблов
        return new VarD(value - arg.getValue());
    }

    public VarD mul(VarD arg) {//Умножение даблов
        return new VarD(value * arg.getValue());
    }

    public VarD div(VarD arg) {//Деление даблов
        return new VarD(value / arg.getValue());
    }

    @Override
    public Var add(Var arg) {
        if (arg instanceof VarD) return add((VarD) arg);
        else return arg.add(this);
    }

    @Override
    public Var sub(Var arg) {
        if (arg instanceof VarD) return sub((VarD) arg);
        else return arg.add(this);
    }

    @Override
    public Var mul(Var arg) {
        if (arg instanceof VarD) return mul((VarD) arg);
        else return arg.add(this);
    }

    @Override
    public Var div(Var arg) {
        if (arg instanceof VarD) return div((VarD) arg);
        else return arg.add(this);
    }
}
