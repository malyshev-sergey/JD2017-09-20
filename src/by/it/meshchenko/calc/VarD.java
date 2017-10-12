package by.it.meshchenko.calc;

public class VarD extends Var implements IVariable, IVarVisitor {

    private double value;
    private Var varOperand2;

    // Конструкторы
    VarD(double value) {
        this.value = value;
    }
    VarD(String strValue) {
        fromString(strValue);
    }

    // get set
    public double getValue() {
        return value;
    }

    // extends Var
    @Override
    public Var accept(IVarVisitor iVar, Operation op) {
        if(op == Operation.ADD){
            return iVar.visitAdd(this);
        }
        else if(op == Operation.SUB){
            return iVar.visitSub(this);
        }
        else if (op == Operation.MUL){
            return iVar.visitMul(this);
        }
        else if(op == Operation.DIV){
            return iVar.visitDiv(this);
        }
        else {
            return null;
        }
    }
    @Override
    public Var add(Var var) {
        return var.accept(this, Operation.ADD);
        /*
        if (var instanceof VarD)
            return new VarD(this.value + ((VarD) var).value);
        else
            return var.add(this);
        */
    }
    @Override
    public Var sub(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value - ((VarD) var).value);
        else
            return super.sub(var);
    }
    @Override
    public Var mul(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value * ((VarD) var).value);
        else
            return var.mul(this);
    }
    @Override
    public Var div(Var var) {
        if (var instanceof VarD)
            return new VarD(this.value / ((VarD) var).value);
        else
            return super.sub(var);
    }

    // implements IVariable
    @Override
    public String toString() {
        return Double.toString(value);
    }
    @Override
    public void fromString(String strValue) {
        this.value = Double.parseDouble(strValue);
    }


    // implements IVarVisitor
    @Override
    public Var visitAdd(VarD varD) {
        return new VarD(this.value + varD.value);
    }
    @Override
    public Var visitAdd(VarV varV) {
        return null;
    }
    @Override
    public Var visitAdd(VarM varM) {
        return null;
    }
    @Override
    public Var visitSub(VarD varD) {
        return null;
    }
    @Override
    public Var visitSub(VarV varV) {
        return null;
    }
    @Override
    public Var visitSub(VarM varM) {
        return null;
    }
    @Override
    public Var visitMul(VarD varD) {
        return null;
    }
    @Override
    public Var visitMul(VarV varV) {
        return null;
    }
    @Override
    public Var visitMul(VarM varM) {
        return null;
    }
    @Override
    public Var visitDiv(VarD varD) {
        return null;
    }
    @Override
    public Var visitDiv(VarV varV) {
        return null;
    }
    @Override
    public Var visitDiv(VarM varM) {
        return null;
    }

}
