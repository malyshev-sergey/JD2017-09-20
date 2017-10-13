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

    public Var defaultOp(String type, Var v){
        if (!v.isUsed()) {
            used = true;
            if("add".equals(type)) return v.add(this);
            else if ("mul".equals(type)) return v.mul(this);
            else if ("sub".equals(type)) return v.sub(this);
            else if ("div".equals(type)) return v.div(this);
            return null;
        } else
            return null;
    }
    public Var recall(String op, Var v){
        return v.defaultOp(op, this);
    }
}
