package by.it.shelkovich.calc;

public class VarD extends Var {
    private Double value;

    double getValue() {
        return value;
    }

    VarD(String value) {
        this(Double.parseDouble(value));
    }

    VarD(double value) {
        this.value = value;
    }

    @Override
    public Var add(VarD v1) {
        System.out.println("Сложение числа с числом");
        return new VarD(value + v1.getValue());
    }

    @Override
    public Var mul(VarD v1) {
        System.out.println("Сложение числа с числом");
        return new VarD(value * v1.getValue());
    }

    @Override
    public Var sub(VarD v1) {
        System.out.println("Разность числа с числом");
        return new VarD(value - v1.getValue());
    }

    @Override
    public Var div(VarD v1) {
        System.out.println("Деление числа на число");
        return new VarD(value / v1.getValue());
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
