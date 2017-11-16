package by.it.meshchenko.calc;

public class VarF extends Var implements IVariable, IOperationVisitorAdd,
        IOperationVisitorDiv, IOperationVisitorMul, IOperationVisitorSub,
        IOperationVisitorAssign {

    private double value;
    private Var varOperand2;

    // Конструкторы
    VarF(){}
    VarF(double value) {
        this.value = value;
    }
    VarF(String strValue) {
        fromString(strValue);
    }

    // get set
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
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
    @Override
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
        return Double.toString(value);
    }
    @Override
    public boolean fromString(String strValue) {
        boolean res = false;
        Double temp = OperationCore.PatternExValToDouble(strValue);
        if(temp != null){
            this.value = temp;
            res = true;
        }
        return res;
    }


    // implements IOperationVisitorAdd
    @Override
    public Var visitAdd(VarF varF) {
        return OperationCore.add_FF(this, varF);
    }
    @Override
    public Var visitAdd(VarV varV) {
        return OperationCore.add_VF(varV, this);
    }
    @Override
    public Var visitAdd(VarM varM) {
        return OperationCore.add_MF(varM, this);
    }

    // implements IOperationVisitorDiv
    @Override
    public Var visitDiv(VarF varF) {
        return OperationCore.div_FF(this, varF);
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
        return OperationCore.mul_FF(this, varF);
    }
    @Override
    public Var visitMul(VarV varV) {
        return OperationCore.mul_FV(this, varV);
    }
    @Override
    public Var visitMul(VarM varM) {
        return OperationCore.mul_FM(this, varM);
    }

    // implements IOperationVisitorSub
    @Override
    public Var visitSub(VarF varF) {
        return OperationCore.sub_FF(this, varF);
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
        setValue(varF.getValue());
        return true;
    }
    @Override
    public boolean visitAssign(VarV varV){
        return super.assign(varOperand2);
    }
    @Override
    public boolean visitAssign(VarM varM){
        return super.assign(varOperand2);
    }

    @Override
    public Var getVar() {
        return new VarF();
    }
}
