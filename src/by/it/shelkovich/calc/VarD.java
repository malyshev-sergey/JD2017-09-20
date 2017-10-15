package by.it.shelkovich.calc;

public class VarD extends Var {
    private Double value;

    double getValue() {
        return value;
    }

    VarD(String value) {
        setFrom(value);
    }

    VarD(double value) {
        this.value = value;
    }

    VarD(VarD value) {
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
        System.out.println("Сложение числа с числом");
        return new VarD(value + v1.getValue());
    }

    @Override
    public Var mul(VarD v1) {
        System.out.println("Умножение числа на число");
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
    public Var defaultOp(String type, Var v, boolean setUsed){
        if (!v.isUsed()) {
            if (setUsed) used = true;
            if("add".equals(type)) return v.add(this);
            else if ("mul".equals(type)) return v.mul(this);
            else if ("sub".equals(type)) return v.sub(this);
            else if ("div".equals(type)) return v.div(this);
            return null;
        } else
            v.setUsed(false);
            return null;
    }


}
