package by.it.shelkovich.calc;

public class VarM extends Var{
    private double[][] value;
    double[][] getValue(){
        return value;
    }

    VarM(String value) {
        super('M');
        //this.value = Double.parseDouble(value);
    }
    VarM(double[][] value) {
        super('M');
        this.value = value;
    }

    public VarM add(VarD arg) {
        System.out.println("сложение матрицы с числом");
        return null;
    }

    public VarM add(VarV arg) {
        System.out.println("сложение матрицы с вектором");
        return null;
    }

    public VarM add(VarM arg) {
        System.out.println("сложение матрицы с матрицей");
        return null;
    }

    @Override
    public Var add(Var arg) {
        if(arg.getType() == 'D') return add((VarD) arg);
        else if (arg.getType() == 'V') return add((VarV) arg);
        else if (arg.getType() == 'M') return add((VarM) arg);
        else return arg.add(this);

    }
}
