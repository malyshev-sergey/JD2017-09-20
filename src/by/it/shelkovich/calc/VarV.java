package by.it.shelkovich.calc;

import by.it.shelkovich.calc.Exceptions.IllegalVectorOperationException;
import by.it.shelkovich.calc.interfaces.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends Var {
    private double[] value;

    double[] getValue() {
        return value;
    }

    public VarV(String value) {
        setFrom(value);
    }

    VarV(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    VarV(VarV v) {
        this(v.value);
    }

    public String toString(){
        StringBuilder result = new StringBuilder(value.length*2+2);
        result.append('{');
        String delimiter = "";
        for(double val: value){
            result.append(delimiter).append(String.valueOf(val));
            delimiter = ",";
        }
        result.append('}');
        return result.toString();
    }
    public void setFrom(String str){
        Pattern p = Pattern.compile(Patterns.exVal);
        value = new double[str.split(",").length];
        Matcher m = p.matcher(str);
        int i = 0;
        while (m.find())
            value[i++] = Double.parseDouble(m.group());
    }

    @Override
    public Var add(VarD v1) {
        //System.out.println("сложение вектора с числом");
        VarV result = new VarV(this);
        for (int i = 0; i < result.value.length; i++) {
            result.value[i] = result.value[i] + v1.getValue();
        }
        return result;
    }

    @Override
    public Var mul(VarD v1) {
        //System.out.println("умножение вектора на число");
        VarV result = new VarV(this);
        for (int i = 0; i < result.value.length; i++) {
            result.value[i] = result.value[i] * v1.getValue();
        }
        return result;
    }

    @Override
    public Var sub(VarD v1) {
        //System.out.println("разность вектора с числом");
        VarV result = new VarV(this);
        for (int i = 0; i < result.value.length; i++) {
            result.value[i] = result.value[i] - v1.getValue();
        }
        return result;
    }

    @Override
    public Var div(VarD v1) {
        //System.out.println("деление вектора на число");
        VarV result = new VarV(this);
        for (int i = 0; i < result.value.length; i++) {
            if (v1.getValue() == 0) throw new ArithmeticException("Деление на 0");
            result.value[i] = result.value[i] / v1.getValue();
        }
        return result;
    }


    @Override
    public Var add(VarV v1) throws IllegalVectorOperationException {
        //System.out.println("сложение вектора с вектором");
        VarV result = new VarV(this);
        if (value.length == v1.value.length) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] + v1.value[i];
            }
        } else
            throw new IllegalVectorOperationException("векторы разной длинны");

        return result;
    }

    @Override
    public Var mul(VarV v1) {
        //System.out.println("умножение вектора на вектор");
        VarV result = new VarV(this);
        if (value.length == v1.value.length) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] * v1.value[i];
            }
        } else
            throw new IllegalVectorOperationException("векторы разной длинны");
        return result;
    }

    @Override
    public Var sub(VarV v1) {
        //System.out.println("разность вектора с вектором");
        VarV result = new VarV(this);
        if (value.length == v1.value.length) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] - v1.value[i];
            }
        } else
            throw new IllegalVectorOperationException("векторы разной длинны");
        return result;
    }

    @Override
    public Var defaultOp(String type, Var v, boolean setUsed) {
        if (!v.isUsed()) {
            if (setUsed) used = true;
            if ("add".equals(type)) return v.add(this);
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
