package by.it.shelkovich.calc;

public class VarD extends Var {
    private Double value;

    double getValue() {
        return value;
    }

    public VarD(String value) {
        setFrom(value);
    }

    public VarD(double value) {
        this.value = value;
    }

    public VarD(VarD value) {
        this.value = value.getValue();
    }

    public String toString(){
        return String.valueOf(value);
    }
    public void setFrom(String str){
        this.value = Double.parseDouble(str);
    }

    @Override
    public Var add(VarD v1) {
        //System.out.println("Сложение числа с числом");
        return new VarD(value + v1.getValue());
    }

    @Override
    public Var mul(VarD v1) {
        //System.out.println("Умножение числа на число");
        return new VarD(value * v1.getValue());
    }

    @Override
    public Var sub(VarD v1) {
        ///System.out.println("Разность числа с числом");
        return new VarD(value - v1.getValue());
    }

    @Override
    public Var div(VarD v1) {
        //System.out.println("Деление числа на число");
        if (v1.getValue() == 0) throw new ArithmeticException("Деление на 0");
        return new VarD(value / v1.getValue());
    }

    @Override
    public Var defaultOp(String type, Var v, boolean setUsed){
        if (!v.isUsed()) {
            if (setUsed) used = true;
            if("add".equals(type)) return v.add(this);
            else if ("mul".equals(type)) return v.mul(this);
            else if ("sub".equals(type)) return v.sub(this);
            else if ("div".equals(type)) return v.div(this);
            else if ("set".equals(type)) return v.set(this);
            return null;
        } else
            v.setUsed(false);
            return null;
    }


}
