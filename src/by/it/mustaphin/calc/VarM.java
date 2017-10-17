package by.it.mustaphin.calc;

import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarM extends Var {

    private double value[][];

    public double[][] getValue() {
        return value;
    }

    @Override
    public void fromString(String str) {
        Pattern pat = Pattern.compile("((-?([0-9.])+),?)+");
        Matcher mat = pat.matcher(str);
        LinkedHashSet<double[]> setStr = new LinkedHashSet<>();
        while (mat.find()) {
            String tmp[] = mat.group().split("[,]");
            double var[] = new double[tmp.length];
            for (int i = 0; i < tmp.length; i++) {
                var[i] = Double.parseDouble(tmp[i]);
            }
            setStr.add(var);
        }
        this.value = new double[setStr.size()][];
        int count = 0;
        for (double[] var : setStr) {
            this.value[count] = var;
            count++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (double subValue[] : value) {
            sb.append("{");
            String delimeter = "";
            for (double var : subValue) {
                sb.append(delimeter).append(var);
                delimeter = ",";
            }
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }

    public VarM(double[][] value) {
        this.value = value;
    }

    public VarM(String str) {
        this.fromString(str);
    }

    @Override
    public Var add(Var var) {
        if (var instanceof VarM) {
            //Здесь должно выполняться сложение матрицы с матрицией
            return null;
        } else if (var instanceof VarV) {
            return super.add(var);
        } else if (var instanceof VarD) {
            //Здесь должно выполняться сложение матрицы со скалярной величиной
            return null;
        }
        return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarM) {
            //Здесь должно выполняться умножение матрицы с матрицией
            return null;
        } else if (var instanceof VarV) {
            return super.add(var);
        } else if (var instanceof VarD) {
            //Здесь должно выполняться умножение матрицы со скалярной величиной
            return null;
        }
        return super.mul(var);
    }

    @Override
    public Var div(Var var) {
        return super.div(var);
    }
}
