package by.it.meshchenko.calc;

public class VarD extends Var implements IVariable, IOperationVisitorAdd,
        IOperationVisitorDiv, IOperationVisitorMul, IOperationVisitorSub {

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
        /*
        if (var instanceof VarD)
            return new VarD(this.value + ((VarD) var).value);
        else
            return var.add(this);
        */
    }
    @Override
    public Var sub(Var var) {
        varOperand2 = var;
        return var.acceptSub(this);
        /*
        if (var instanceof VarD)
            return new VarD(this.value - ((VarD) var).value);
        else
            return super.sub(var);
            */
    }
    @Override
    public Var mul(Var var) {
        varOperand2 = var;
        return var.acceptMul(this);
        /*
        if (var instanceof VarD)
            return new VarD(this.value * ((VarD) var).value);
        else
            return var.mul(this);
            */
    }
    @Override
    public Var div(Var var) {
        varOperand2 = var;
        return var.acceptDiv(this);
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


    // implements IOperationVisitorAdd
    @Override
    public Var visitAdd(VarD varD) {
        return OperationCore.add_DD(this, varD);
    }
    @Override
    public Var visitAdd(VarV varV) {
        return OperationCore.add_D_V(this, varV);
    }
    @Override
    public Var visitAdd(VarM varM) {
        return null;
    }

    // implements IOperationVisitorDiv
    @Override
    public Var visitDiv(VarD varD) {
        return new VarD(this.value / varD.value);
    }
    @Override
    public Var visitDiv(VarV varV) {
        return super.div(varOperand2);
    }
    @Override
    public Var visitDiv(VarM varM) {
        return super.div(varOperand2);
    }

    // implements IOperationVisitorMul
    @Override
    public Var visitMul(VarD varD) {
        return new VarD(this.value * varD.value);
    }
    @Override
    public Var visitMul(VarV varV) {
        return null;
    }
    @Override
    public Var visitMul(VarM varM) {
        return null;
    }

    // implements IOperationVisitorSub
    @Override
    public Var visitSub(VarD varD) {
        return new VarD(this.value - varD.value);
    }
    @Override
    public Var visitSub(VarV varV) {
        return super.sub(varOperand2);
    }
    @Override
    public Var visitSub(VarM varM) {
        return super.sub(varOperand2);
    }


}
