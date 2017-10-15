package by.it.meshchenko.calc;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class VarV extends Var implements IVariable, IOperationVisitorAdd,
        IOperationVisitorDiv, IOperationVisitorMul, IOperationVisitorSub{
    private double[] value;
    private Var varOperand2;

    // Конструкторы
    VarV(double[] value) {
        this.value = value;
    }
    VarV(String strVector) {
        fromString(strVector);
    }

    // get set
    public double[] getValue() {
        return value;
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


    // implements IVariable
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

    // implements IOperationVisitorAdd
    @Override
    public Var visitAdd(VarF varF) {
        return OperationCore.add_VF(this, varF);
    }
    // операция не возможна, вызываем метод суперкласса
    @Override
    public Var visitAdd(VarV varV) {
        // если не совпадают размеры, операции может и не быть
        Var res = OperationCore.add_VV(this, varV);
        if(res != null) return res;
        return super.mul(varOperand2);
    }
    // операция не возможна, вызываем метод суперкласса
    @Override
    public Var visitAdd(VarM varM) {
        return super.add(varOperand2);
    }

    // implements IOperationVisitorDiv
    @Override
    public Var visitDiv(VarF varF) {
        return OperationCore.div_VF(this, varF);
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
        return OperationCore.mul_FV(varF, this);
    }
    // операция не возможна, вызываем метод суперкласса
    @Override
    public Var visitMul(VarV varV) {
        return super.mul(varOperand2);
    }
    @Override
    public Var visitMul(VarM varM) {
        // если не совпадают размеры, операции может и не быть
        Var res = OperationCore.mul_VM(this, varM);
        if(res != null) return res;
        return super.mul(varOperand2);
    }

    // implements IOperationVisitorSub
    @Override
    public Var visitSub(VarF varF) {
        return OperationCore.sub_VF(this, varF);
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
}
