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

    @Override
    public Var add(VarD v1) {
        System.out.println("сложение вектора с числом");
        return new VarV("");
    }

    @Override
    public Var mul(VarD v1) {
        System.out.println("умножение вектора на число");
        return new VarV("");
    }

    @Override
    public Var sub(VarD v1) {
        System.out.println("разность вектора с числом");
        return new VarV("");
    }

    @Override
    public Var div(VarD v1) {
        System.out.println("деление вектора на число");
        return new VarV("");
    }




    @Override
    public Var add(VarV v1) {
        System.out.println("сложение вектора с вектором");
        return new VarV("");
    }

    @Override
    public Var mul(VarV v1) {
        System.out.println("умножение вектора на вектор");
        return new VarV("");
    }

    @Override
    public Var sub(VarV v1) {
        System.out.println("разность вектора с вектором");
        return new VarV("");
    }

    @Override
    public Var defaultAdd(Var v) {
        if (!v.isUsed()) {
            used = true;
            return v.add(this);
        } else
            return null;

    }

    @Override
    public Var defaultMul(Var v) {
        if (!v.isUsed()) {
            used = true;
            return v.mul(this);
        } else
            return null;
    }

}
