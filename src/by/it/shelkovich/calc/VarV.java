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
        super('V');
        this.value = value;
    }

    public VarV add(VarD arg) {
        System.out.println("сложение вектора с числом");
        return null;
    }

    public VarV add(VarV arg) {
        System.out.println("сложение вектора с вектором");
        return null;
    }

    public Var vAdd(Var arg) {
        return arg.add(this);
    }

    @Override
    public Var add(Var arg) {
        if(arg.getType() == 'D') return add((VarD) arg);
        else if (arg.getType() == 'V') return add((VarV) arg);
        else return arg.add(this);
    }
}
