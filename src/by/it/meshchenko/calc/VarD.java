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
        return var.accept(this, Operation.SUB);
        /*
        if (var instanceof VarD)
            return new VarD(this.value - ((VarD) var).value);
        else
            return super.sub(var);
            */
    }
    @Override
    public Var mul(Var var) {
        return var.accept(this, Operation.MUL);
        /*
        if (var instanceof VarD)
            return new VarD(this.value * ((VarD) var).value);
        else
            return var.mul(this);
            */
    }
    @Override
    public Var div(Var var) {
        return var.accept(this, Operation.DIV);
        /*
        if (var instanceof VarD)
            return new VarD(this.value / ((VarD) var).value);
        else
            return super.sub(var);
            */
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
        VarV result = new VarV(varV.getValue());
        double[] resultVal = result.getValue();
        double operand2 = this.value;
        for (int i = 0; i < resultVal.length; i++)
            resultVal[i] += operand2;
        return result;
    }
    @Override
    public Var visitAdd(VarM varM) {
        return null;
    }
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

}
