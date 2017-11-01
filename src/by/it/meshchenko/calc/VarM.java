package by.it.meshchenko.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarM extends Var implements IVariable, IOperationVisitorAdd,
        IOperationVisitorDiv, IOperationVisitorMul, IOperationVisitorSub,
        IOperationVisitorAssign {

    private double[][] value;
    private Var varOperand2;

    // Конструкторы
    VarM(){}
    VarM(double[][] value) {
        this.value = value;
    }
    VarM(String strMatrix) {
        fromString(strMatrix);
    }

    // get set
    public double[][] getValue() {
        return value;
    }
    public void setValue(double[][] value) {
        this.value = value;
    }

    // extends Var
    @Override
    public Var acceptAdd(IOperationVisitorAdd p) {
        return p.visitAdd(this);
    }
    @Override
    public Var acceptDiv(IOperationVisitorDiv p) {
        return p.visitDiv(this);
    }
    @Override
    public Var acceptMul(IOperationVisitorMul p) {
        return p.visitMul(this);
    }
    @Override
    public Var acceptSub(IOperationVisitorSub p) {
        return p.visitSub(this);
    }
    @Override
    public boolean acceptAssign(IOperationVisitorAssign p) {
        return p.visitAssign(this);
    }

    @Override
    public Var add(Var var) {
        varOperand2 = var;
        return var.acceptAdd(this);
    }
    @Override
    public Var sub(Var var) {
        varOperand2 = var;
        return var.acceptSub(this);
    }
    @Override
    public Var mul(Var var) {
        varOperand2 = var;
        return var.acceptMul(this);
    }
    @Override
    public Var div(Var var) {
        varOperand2 = var;
        return var.acceptDiv(this);
    }
    public boolean assign(Var var){
        varOperand2 = var;
        return var.acceptAssign(this);
    }
    @Override
    public boolean assign(String str){
        if(fromString(str)) {
            return true;
        }
        else {
            return super.assign(str);
        }
    }

    // implements IVariable
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{");
        for (double[] row : value) {
            s.append("{");
            for (double value : row) {
                s.append(value + ",");
            }
            s.replace(s.length()-1,s.length(), "},");
        }
        s.replace(s.length()-1,s.length(), "}");
        return s.toString();
    }
    @Override
    public boolean fromString(String strMatrix) {
        boolean res = false;
        Double temp = null;

        String[] vectorMass = strMatrix.split("},\\{");
        int m = vectorMass.length;
        int n = vectorMass[0].split(",").length;
        value = new double[m][n];
        Pattern p = Pattern.compile(Patterns.exValsimpl);
        for (int i = 0; i < m; i++) {
            Matcher match = p.matcher(vectorMass[i]);
            int j = 0;
            while (match.find()) {
                temp = OperationCore.PatternExValToDouble(match.group());
                if(temp == null){
                    return res = false;
                }
                value[i][j++] = temp;
                res = true;
            }
        }
        return res;
    }

    // implements IOperationVisitorAdd
    @Override
    public Var visitAdd(VarF varF) {
        return OperationCore.add_MF(this, varF);
    }
    // операция не возможна, вызываем метод суперкласса
    @Override
    public Var visitAdd(VarV varV) {
        return super.add(varOperand2);
    }
    @Override
    public Var visitAdd(VarM varM) {
        return OperationCore.add_MM(this, varM);
    }

    // implements IOperationVisitorDiv
    @Override
    public Var visitDiv(VarF varF) {
        return OperationCore.div_MF(this, varF);
    }
    // операция не возможна, вызываем метод суперкласса
    @Override
    public Var visitDiv(VarV varV) {
        return super.div(varOperand2);
    }
    // операция не возможна, вызываем метод суперкласса
    @Override
    public Var visitDiv(VarM varM) {
        return super.div(varOperand2);
    }

    // implements IOperationVisitorMul
    @Override
    public Var visitMul(VarF varF) {
        return OperationCore.mul_FM(varF, this);
    }
    @Override
    public Var visitMul(VarV varV) {
        // если не совпадают размеры, операции может и не быть
        Var res = OperationCore.mul_MV(this, varV);
        if(res != null) return res;
        return super.mul(varOperand2);
    }
    @Override
    public Var visitMul(VarM varM) {
        // если не совпадают размеры, операции может и не быть
        Var res = OperationCore.mul_MM(this, varM);
        if(res != null) return res;
        return super.mul(varOperand2);
    }

    // implements IOperationVisitorSub
    @Override
    public Var visitSub(VarF varF) {
        return OperationCore.sub_MF(this, varF);
    }
    // операция не возможна, вызываем метод суперкласса
    @Override
    public Var visitSub(VarV varV) {
        return super.sub(varOperand2);
    }
    // операция не возможна, вызываем метод суперкласса
    @Override
    public Var visitSub(VarM varM) {
        return super.sub(varOperand2);
    }

    // implements IOperationVisitorAssign
    @Override
    public boolean visitAssign(VarF varF){
        return super.assign(varOperand2);
    }
    @Override
    public boolean visitAssign(VarV varV){
        return super.assign(varOperand2);
    }
    @Override
    public boolean visitAssign(VarM varM){
        setValue(varM.getValue());
        return true;
    }

}
