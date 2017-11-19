package by.it.govor.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


class VarV extends Var implements IVariable {

    private double[] value;

    private VarV(double[] value) {
        this.value = value;
    }

    // implementation IVarable

    VarV(String strVector) {
        fromString(strVector);
    }
    @Override
    public void fromString(String strVector) {
        Pattern p = Pattern.compile(Patterns.exVal);
        value = new double[strVector.split(",").length];
        Matcher m = p.matcher(strVector);
        int i = 0;
        while (m.find())
            value[i++] = Double.parseDouble(m.group());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter = ",";
        }
        sb.append("}");
        return sb.toString();
    }

    // implementation IOperation

    @Override
    public Var add(Var var) {
        VarV result;
        if (var instanceof VarD) {
            result = new VarV(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                result.value[i] += operand2;
            return result;
        } else if (var instanceof VarV) {
            result = new VarV(this.value);
            VarV operand2 = ((VarV) var);
            for (int i = 0; i < value.length; i++)
                result.value[i] += operand2.value[i];
            return result;
        } else
            return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        VarV result;
        if (var instanceof VarD) {
            result = new VarV(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                result.value[i] -= operand2;
            return result;
        } else if (var instanceof VarV) {
            result = new VarV(this.value);
            VarV operand2 = ((VarV) var);
            for (int i = 0; i < value.length; i++)
                result.value[i] -= operand2.value[i];
            return result;
        } else
            return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        VarV result;
        if (var instanceof VarD) {
            result = new VarV(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                result.value[i] *= operand2;
            return result;
        } else if (var instanceof VarV) {
            double sum = 0;
            VarV operand2 = ((VarV) var);
            for (int i = 0; i < value.length; i++)
                sum=this.value[i] + operand2.value[i];
            return new VarD(sum);
        } else
            return super.mul(var);
    }

    @Override
    public Var div(Var var) {
        VarV result;
        if (var instanceof VarD) {
            result = new VarV(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                result.value[i] /= operand2;
            return result;
        } else
            return super.div(var);
    }


}
