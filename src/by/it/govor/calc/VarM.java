package by.it.govor.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VarM  extends Var implements IVariable {
    private double[][] value;
    private VarM(double[][] value) {
        this.value = value;
    }



    VarM(String strMat) {
        fromString(strMat);
    }
    @Override
    public void fromString(String strMat) {
        String[] line = strMat.split("},\\{");
        int a = line.length;
        int y=0;
        for (int i = 0; i < a; i++) {
            if (y < line[i].split(",").length)
                y = line[i].split(",").length;

        }
        int b =y;
        value = new double[a][b];
        Pattern p = Pattern.compile(Patterns.exVal);
        for(int i = 0; i < a ; i++){
            Matcher match = p.matcher(line[i]);
            int j = 0;
            while (match.find()){
                value[i][j++] = Double.parseDouble(match.group());
            }
        }
    }

    @Override
    public String toString() {
        return " , я очень ленивый человек)";
    }

    @Override
    public Var add(Var var) {
        VarM resultFake;
        resultFake = new VarM(this.value);
        if (var instanceof VarD) {
            System.out.print("Матрица+число");
            return resultFake;
        } else if (var instanceof VarV) {

            return super.add(var);
        } else if (var instanceof VarM){
            System.out.print( "Матрица+матрица");
        return resultFake;}else
            return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        VarM resultFake;
        resultFake = new VarM(this.value);
        if (var instanceof VarD) {
            return super.sub(var);
        } else if (var instanceof VarV) {
            return super.sub(var);
        } else if (var instanceof VarM){
            System.out.print("Матрица-матрица");
        return resultFake ;}else
            return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        VarM resultFake;
        resultFake = new VarM(this.value);
        if (var instanceof VarD) {
            System.out.print( "Матрица*число");
            return resultFake;
        } else if (var instanceof VarV) {
            return super.mul(var);
        } else if (var instanceof VarM){
            System.out.print( "Матрица*матрица");
        return resultFake;}else
            return super.mul(var);
    }

    @Override
    public Var div(Var var) {
        VarM resultFake;
        resultFake = new VarM(this.value);
        if (var instanceof VarD) {
            System.out.print("Матрица/число");
            return resultFake;
        } else if (var instanceof VarV) {
            return super.div(var);
        } else if (var instanceof VarM){
            return super.div(var);}else
            return super.div(var);

    }

}
