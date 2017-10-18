//package by.it.ali.calculator;
//
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class VarV extends Var implements Str{
//    private double[] value;
//    private VarV(double[] value) {
//        this.value = value;
//    }
//    VarV(String strVector) {
//        fromString(strVector);
//    }
//    String exVec="\\{((-?([0-9.])+),?)+}";
//
//    @Override
//    public void fromString(String strVector) {
//        Pattern p = Pattern.compile(exVec);
//        value = new double[strVector.split(",").length];
//        Matcher m = p.matcher(strVector);
//        int i = 0;
//        while (m.find())
//            value[i++] = Double.parseDouble(m.group());
//    }
//}
