package by.it.meshchenko.calc;

public abstract class Var implements IOperation {

    public abstract Var acceptAdd(IOperationVisitorAdd p);
    public abstract Var acceptDiv(IOperationVisitorDiv p);
    public abstract Var acceptMul(IOperationVisitorMul p);
    public abstract Var acceptSub(IOperationVisitorSub p);
    public abstract boolean acceptAssign(IOperationVisitorAssign p);

    @Override
    public Var add(Var var) {
        new CalcError("Сложение невозможно");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new CalcError("Вычитание невозможно");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new CalcError("Умножение невозможно");
        return null;
    }

    @Override
    public Var div(Var var) {
        new CalcError("Деление невозможно");
        return null;
    }

    @Override
    public boolean assign(Var var){
        new CalcError("Присвоить значение невозможно");
        return false;
    }
    @Override
    public boolean assign(String str){
        new CalcError("Присвоить значение невозможно");
        return false;
    }
}
