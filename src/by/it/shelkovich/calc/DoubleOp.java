package by.it.shelkovich.calc;

public class DoubleOp extends AbstractOperator{


    VarD add(VarD v1, VarD v2) {//Сложение даблов
        return new VarD(v1.getValue() + v2.getValue());
    }

    public VarD sub(VarD v1, VarD v2) {//Разность даблов
        return new VarD(v1.getValue() - v2.getValue());
    }

    public VarD mul(VarD v1, VarD v2) {//Умножение даблов
        return new VarD(v1.getValue() * v2.getValue());
    }

    public VarD div(VarD v1, VarD v2) {//Деление даблов
        return new VarD(v1.getValue() / v2.getValue());
    }

    @Override
    public Var add(Var v1, Var v2) {
        if (v2 instanceof VarD) return add((VarD) v1, (VarD) v2);
        else {
            if (!used){
                used = true;
                return v2.op.add(v2, (VarD) v1);
            } else{
                return super.add(v1, v2);
            }
        }

    }

    @Override
    public Var sub(Var v1, Var v2) {
        if (v2 instanceof VarD) return sub((VarD) v1, (VarD) v2);
        else {
            if (!v2.op.getUsed()){
                used = true;
                return v2.op.sub((VarD) v2, (VarD) v1);
            } else{
                return super.sub(v1, v2);
            }
        }

    }

    @Override
    public Var mul(Var v1, Var v2) {
        if (v2 instanceof VarD) return mul((VarD) v1, (VarD) v2);
        else {
            if (!used){
                used = true;
                return v2.op.mul((VarD) v2, (VarD) v1);
            } else{
                return super.mul(v1, v2);
            }
        }

    }

    @Override
    public Var div(Var v1, Var v2) {
        if (v2 instanceof VarD) return add((VarD) v1, (VarD) v2);
        else {
            if (!used){
                used = true;
                return v2.op.div((VarD) v2, (VarD) v1);
            } else{
                return super.div(v1, v2);
            }
        }

    }
}
