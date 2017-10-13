package by.it.mustaphin.calc;

import java.util.regex.Pattern;

public class VarM extends Var {

    private double value[][];

    public double[][] getValue() {
        return value;
    }

    @Override
    public void fromString(String str) {

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

    @Override
    public Var add(Var var) {
        return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        return super.mul(var);
    }

    @Override
    public Var div(Var var) {
        return super.div(var);
    }
}
