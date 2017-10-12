package by.it.meshchenko.calc;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class VarV extends Var implements IVariable, IVarVisitor{
    private double[] value;
    private Var varOperand2;

    // Конструкторы
    VarV(double[] value) {
        this.value = value;
    }
    VarV(String strVector) {
        fromString(strVector);
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
        varOperand2 = var;
        return var.accept(this, Operation.ADD);
        /*
        VarV result;
        if (var instanceof VarD) {
            result = new VarV(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                result.value[i] += operand2;
            return result;
        } else if (var instanceof VarV) {
            result = new VarV(this.value);
            VarV operand2 = ((VarV) var);
            for (int i = 0; i < value.length; i++)
                result.value[i] += operand2.value[i];
            return result;
        } else
            return super.add(var);
            */
    }

    @Override
    public Var sub(Var var) {
        VarV result;
        if (var instanceof VarD) {
            result = new VarV(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                result.value[i] -= operand2;
            return result;
        } else if (var instanceof VarV) {
            result = new VarV(this.value);
            VarV operand2 = ((VarV) var);
            for (int i = 0; i < value.length; i++)
                result.value[i] -= operand2.value[i];
            return result;
        } else
            return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        VarV result;
        if (var instanceof VarD) {
            result = new VarV(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                result.value[i] *= operand2;
            return result;
        } else if (var instanceof VarV) {
            double sum = 0;
            VarV operand2 = ((VarV) var);
            for (int i = 0; i < value.length; i++)
                sum=this.value[i] + operand2.value[i];
            return new VarD(sum);
        } else
            return super.mul(var);
    }

    @Override
    public Var div(Var var) {
        VarV result;
        if (var instanceof VarD) {
            result = new VarV(this.value);
            double operand2 = ((VarD) var).getValue();
            for (int i = 0; i < value.length; i++)
                result.value[i] /= operand2;
            return result;
        } else
            return super.div(var);
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

    // implements IVarVisitor
    @Override
    public Var visitAdd(VarD varD) {
        VarV result = new VarV(this.value);
        double operand2 = varD.getValue();
        for (int i = 0; i < value.length; i++)
            result.value[i] += operand2;
        return result;
    }

    @Override
    public Var visitAdd(VarV varV) {
        VarV result = new VarV(this.value);
        for (int i = 0; i < value.length; i++)
            result.value[i] += varV.value[i];
        return result;
    }

    @Override
    public Var visitAdd(VarM varM) {
        return super.add(varOperand2);
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
