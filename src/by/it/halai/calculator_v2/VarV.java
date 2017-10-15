package by.it.halai.calculator_v2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vitaly Halai
 */
public class VarV extends Var implements IVariable {
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

    VarV(double[] value) {
        this.value = value;
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
}
