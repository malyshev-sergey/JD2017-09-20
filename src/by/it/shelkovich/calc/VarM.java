package by.it.shelkovich.calc;

import by.it.shelkovich.calc.Exceptions.MatrixMultiplyException;
import by.it.shelkovich.calc.interfaces.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarM extends Var {
    private double[][] value;

    double[][] getValue() {
        return value;
    }

    VarM(String value) {
        setFrom(value);
    }

    VarM(double[][] value) {
        this.value = new double[value.length][];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = new double[value[i].length];
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    VarM(VarM v) {
        this(v.value);
    }

    public String toString(){
        StringBuilder result = new StringBuilder((value.length+2)*value[0].length*4+2);
        result.append('{');
        String delimiter1 = "";
        String delimiter2 = "";
        for (int i = 0; i < value.length ; i++) {
            result.append(delimiter1).append('{');
            delimiter1 = ",";
            delimiter2 = "";
            for (int j = 0; j < value[i].length ; j++) {
                result.append(delimiter2).append(String.valueOf(value[i][j]));
                delimiter2 = ",";
            }
            result.append('}');
        }
        result.append('}');
        return result.toString();
    }


    public void setFrom(String str){
        Pattern pVec = Pattern.compile(Patterns.exVec);
        Matcher mVec = pVec.matcher(str);
        int i=0;
        while (mVec.find())
            i++;
        mVec.reset();
        value = new double[i][];
        i=0;
        while (mVec.find()){
            String lineStr = mVec.group();
            double[] line = new double[lineStr.split(",").length];

            Pattern pVal = Pattern.compile(Patterns.exVal);
            Matcher mVal = pVal.matcher(lineStr);
            int k = 0;
            while (mVal.find())
                line[k++] = Double.parseDouble(mVal.group());
            value[i++] = line;
        }
    }

    public VarM add(VarD arg) {
        //System.out.println("сложение матрицы с числом");
        VarM result = new VarM(this);
        for (int i = 0; i < result.value.length; i++) {
            for (int j = 0; j < result.value[i].length; j++) {
                result.value[i][j] = result.value[i][j] + arg.getValue();
            }
        }
        return result;
    }

    public VarM mul(VarD arg) {
        //System.out.println("Умножение матрицы на число");
        VarM result = new VarM(this);
        for (int i = 0; i < result.value.length; i++) {
            for (int j = 0; j < result.value[i].length; j++) {
                result.value[i][j] = result.value[i][j] * arg.getValue();
            }
        }
        return result;
    }

    public VarM sub(VarD arg) {
        //System.out.println("Разность матрицы с числом");
        VarM result = new VarM(this);
        for (int i = 0; i < result.value.length; i++) {
            for (int j = 0; j < result.value[i].length; j++) {
                result.value[i][j] = result.value[i][j] - arg.getValue();
            }
        }
        return result;
    }

    public VarM div(VarD arg) {
        //System.out.println("Деление матрицы на число");
        VarM result = new VarM(this);
        for (int i = 0; i < result.value.length; i++) {
            for (int j = 0; j < result.value[i].length; j++) {
                if (arg.getValue() == 0) throw new ArithmeticException("Деление на 0");
                result.value[i][j] = result.value[i][j] / arg.getValue();
            }
        }
        return result;
    }

    public VarV mul(VarV arg) {
        //System.out.println("Умножение матрицы на вектор");
        double[] result;

        if (this.value[0].length == arg.getValue().length) {
            double argArray[] = arg.getValue();
            result = new double[this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                double res = 0;
                for (int j = 0; j < this.value[i].length; j++) {
                    res = res + this.value[i][j] * argArray[j];
                }
                result[i] = res;
            }
        } else
            throw new MatrixMultiplyException("Число столбцов матрицы не соответствует числу элементов в векторе!");


        return new VarV(result);
    }


    public VarM add(VarM arg) {
        //System.out.println("Cложение матрицы с матрицей");
        VarM result = new VarM(this);
        for (int i = 0; i < result.value.length; i++) {
            for (int j = 0; j < result.value[i].length; j++) {
                result.value[i][j] = result.value[i][j] + arg.value[i][j];
            }
        }
        return result;
    }

    public VarM mul(VarM arg) {
        //System.out.println("Умножение матрицы на матрицу");
        VarM result;

        if (this.value[0].length == arg.value.length) {
            result = new VarM(new double[this.value.length][arg.value[0].length]);

            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < arg.value[i].length; j++) {
                    double res = 0;
                    for (int k = 0; k < arg.value.length; k++) {
                        res = res + this.value[i][k] * arg.value[k][j];
                    }
                    result.value[i][j] = res;
                }
            }
        } else
            throw new MatrixMultiplyException("Число столбцов в первой матрице не соответствует числу строк во второй!");


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
