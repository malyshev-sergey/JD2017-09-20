package by.it.malyshev.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class VarV extends Var implements IVariable {

    private double[] value;

    public double[] getValue() {
        return value;
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

//    VarV(double[] value){
//            this.value = value;
//    }

    VarV(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    VarV(VarV init) {
        this.value = new double[init.value.length];
        System.arraycopy(init.value, 0, this.value, 0, this.value.length);
    }


    VarV(String strVector) {
        fromString(strVector);
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

    // impl IVarable

    @Override
    public Var add(Var var) {
        VarV result;
        if (var instanceof VarD) {
            result = new VarV(this);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < result.value.length; i++)
                result.value[i] += operand2;
            return result;
        } else if (var instanceof VarV && (this.value.length==(((VarV) var).value.length))) {
            result = new VarV(this);
            VarV operand2 = (VarV) var;
            for (int i = 0; i < result.value.length; i++)
                result.value[i] += operand2.value[i];
            return result;
        } else
            return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        VarV result;
        if (var instanceof VarD) {
            result = new VarV(this);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                result.value[i] -= operand2;
            return result;
        } else if (var instanceof VarV && (this.value.length==(((VarV) var).value.length))) {
            result = new VarV(this.value);
            VarV operand2 = (VarV) var;
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
            result = new VarV(this);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < result.value.length; i++)
                result.value[i] *= operand2;
            return result;
        } else if (var instanceof VarV && (this.value.length==(((VarV) var).value.length))) {
            double sum = 0;
            VarV v1 = new VarV(this);
            VarV operand2 = (VarV) var;
            for (int i = 0; i < v1.value.length; i++)
                sum+=v1.value[i] + operand2.value[i];
            return new VarD(sum);
        } else if (var instanceof VarM) {
            System.out.print("Опкрация пока не реализована. ");
            return super.mul(var);
        } else
            return super.mul(var);
    }




    @Override
    public Var div(Var var) {
//        VarV result;
        if (var instanceof VarD) {
            VarV result = new VarV(this);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < result.value.length; i++)
                result.value[i] /= operand2;
            return result;
        } else
            return super.div(var);
    }


}