package by.it.malyshev.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class VarM extends Var implements IVariable {

    private double[][] value;

    public double[][] getValue() {
        return value;
    }


    @Override
    public void fromString(String strMatrix) {
        Pattern p = Pattern.compile(Patterns.exVec);
        Matcher m = p.matcher(strMatrix);
        if (m.find()) {
            value = new double[strMatrix.split("\\u007D,").length][m.group().split(",").length];
        }
        int i = 0;
        m.reset();
        while (m.find()) {
            Pattern pV = Pattern.compile(Patterns.exVal);
            Matcher mV = pV.matcher(m.group());
            int j = 0;
            while (mV.find()) {
                value[i][j++] = Double.parseDouble(mV.group());
            }
            i++;
        }
    }

    VarM(double[][] value) {
        this.value = value;
    }

    VarM(String strMatrix) {
        fromString(strMatrix);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (!(value[0].length==1)) {
            String delimiter2 = "";
            for (double[] r : value) {
                sb.append(delimiter2).append("{");
                String delimiter = "";
                for (double v : r) {
                    sb.append(delimiter).append(v);
                    delimiter = ",";
                }
                sb.append("}");
                delimiter2 = ",";
            }
        } else {
            String delimiter = "";
            for (int i=0;i<value.length;i++) {
                sb.append(delimiter).append(value[i][0]);
                delimiter = ",";
            }
        }
        sb.append("}");
        return sb.toString();
    }

    static void print2DArray(double[][] arr) {
        for (double[] r : arr) {
            for (double value : r) {
                System.out.printf("%10.4f ", value);
            }
            System.out.println();
        }
    }


    // impl IVarable

    @Override
    public Var add(Var var) {
        VarM result;
        if (var instanceof VarD) {
            result = new VarM(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                for (int j = 0; j < value[0].length; j++) {
                    result.value[i][j] += operand2;
                }
            return result;
        } else if (var instanceof VarM && (this.value[0].length==((VarM) var).value.length)) {
            result = new VarM(this.value);
            VarM operand2 = ((VarM) var);
            for (int i = 0; i < value.length; i++)
                for (int j = 0; j < value[0].length; j++) {
                    result.value[i][j] += operand2.value[i][j];
                }
            return result;
        } else
            return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        VarM result;
        if (var instanceof VarD) {
            result = new VarM(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                for (int j = 0; j < value[0].length; j++) {
                    result.value[i][j] -= operand2;
                }
            return result;
        } else if (var instanceof VarM && (this.value[0].length==((VarM) var).value.length)) {
            result = new VarM(this.value);
            VarM operand2 = ((VarM) var);
            for (int i = 0; i < value.length; i++)
                for (int j = 0; j < value[0].length; j++) {
                    result.value[i][j] -= operand2.value[i][j];
                }
            return result;
        } else
            return super.add(var);
    }


    @Override
    public Var mul(Var var) {
        VarM result;
        if (var instanceof VarD) {
            result = new VarM(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                for (int j = 0; j < value[0].length; j++) {
                    result.value[i][j] *= operand2;
                }
            return result;
        } else if (var instanceof VarV && (this.value[0].length==((VarV) var).getValue().length)) {
            double[] operand2 = ((VarV) var).getValue();
            double[][] temp=new double[this.value.length][1];
            result = new VarM(temp);
            for (int i = 0; i < this.value.length; i++)
                for (int j = 0; j < operand2.length; j++)
                    result.value[i][0] += this.value[i][j] * operand2[j];
            System.out.print("column-vector ");
            return result;
        } else if (var instanceof VarM && (this.value[0].length==((VarM) var).value.length)) {
            VarM operand2 = ((VarM) var);
            double[][] temp = new double[this.value.length][operand2.value.length];
            result = new VarM(temp);
            for (int i = 0; i < value.length; i++)
                for (int j = 0; j < operand2.value[0].length; j++)
                    for (int k = 0; k < operand2.value.length; k++)
                        result.value[i][j] += this.value[i][k] * operand2.value[k][j];
            return result;
        } else
            return super.mul(var);
    }


    @Override
    public Var div(Var var) {
        VarM result;
        if (var instanceof VarD) {
            result = new VarM(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                for (int j = 0; j < value[0].length; j++) {
                    result.value[i][j] /= operand2;
                }
            return result;
        } else
            return super.div(var);
    }

}
