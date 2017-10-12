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
    public Var defaultAdd(Var v) {
        if (!v.isUsed()){
            used = true;
            return v.add(this);
        }else
            return null;

    }

    @Override
    public Var defaultMul(Var v) {
        if (!v.isUsed()){
            used = true;
            return v.mul(this);
        }else
            return null;
    }

}
