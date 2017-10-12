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




}
