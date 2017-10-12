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

    public VarD add(VarD arg) {
        System.out.println("Сложение даблов");
        return new VarD(value + arg.getValue());
    }

    @Override
    public Var add(Var arg) {
        if (arg instanceof VarD) return sub((VarD) arg);
        else return arg.add(this);
    }


    public VarD sub(VarD arg) {
        System.out.println("Разность даблов");
        return new VarD(value - arg.getValue());
    }

    @Override
    public Var sub(Var arg) {
        if (arg instanceof VarD) return sub((VarD) arg);
        else return arg.add(this);
    }
}
