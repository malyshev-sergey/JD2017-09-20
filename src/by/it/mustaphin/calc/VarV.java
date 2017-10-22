package by.it.mustaphin.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends Var {

    private double value[];

    @Override
    public void fromString(String str) {
        Pattern pat = Pattern.compile(Patterns.exVal);
        value = new double[str.split(",").length];
        Matcher mat = pat.matcher(str);
        int i = 0;
        while (mat.find()) {
            value[i++] = Double.parseDouble(mat.group());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimeter = "";
        for (double varDouble : value) {
            sb.append(delimeter).append(varDouble);
            delimeter = ",";
        }
        sb.append("}");
        return sb.toString();
    }

    public VarV(double[] value) {
        this.value = value;
    }

    public VarV(String str) {
//        System.out.println("VarV constructor from String");
        fromString(str);
    }

    @Override
    public Var add(Var var) {
        VarV result = new VarV(this.value);
        if (var instanceof VarV) {
//            System.out.println("вектора с вектором\n");
            for (int i = 0; i < this.value.length; i++) {
                result.value[i] += ((VarV) var).value[i];
            }
            return result;
        } else if (var instanceof VarD) {
//            System.out.println("вектора с числом\n");
            for (int i = 0; i < this.value.length; i++) {
                result.value[i] += ((VarD) var).getValue();
            }
            return result;
        } else
            return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        VarV result = new VarV(this.value);
        if (var instanceof VarV && ((VarV) var).value.length == this.value.length) {
//            System.out.println("вектора из вектора\n");
            for (int i = 0; i < this.value.length; i++) {
                result.value[i] -= ((VarV) var).value[i];
            }
            return result;
        } else if (var instanceof VarD) {
//            System.out.println("вектора из числа\n");
            for (int i = 0; i < this.value.length; i++) {
                result.value[i] -= ((VarD) var).getValue();
            }
            return result;
        } else
            return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        VarV result = new VarV(this.value);
        if (var instanceof VarV) {
//            System.out.println("вектора на вектор\n");
            for (int i = 0; i < this.value.length; i++) {
                result.value[i] *= ((VarV) var).value[i];
            }
            return result;
        } else if (var instanceof VarD) {
//            System.out.println("вектора на число\n");
            for (int i = 0; i < this.value.length; i++) {
                result.value[i] *= ((VarD) var).getValue();
            }
            return result;
        } else
            return super.mul(var);
    }

    @Override
    public Var div(Var var) {
        VarV result = new VarV(this.value);
        if (var instanceof VarV && ((VarV) var).value.length == this.value.length) {
//            System.out.println("вектора на вектор\n");
            if (((VarV) var).value.length == this.value.length) {
                for (int i = 0; i < this.value.length; i++) {
                    result.value[i] /= ((VarV) var).value[i];
                }
                return result;
            } else return super.div(var);
        } else if (var instanceof VarD) {
//            System.out.println("вектора на число\n");
            for (int i = 0; i < this.value.length; i++) {
                result.value[i] /= ((VarD) var).getValue();
            }
            return result;
        }
        return super.div(var);
    }
}
