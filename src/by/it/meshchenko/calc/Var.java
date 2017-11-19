package by.it.meshchenko.calc;

public abstract class Var implements IOperation {

    public abstract Var acceptAdd(IOperationVisitorAdd p);
    public abstract Var acceptDiv(IOperationVisitorDiv p);
    public abstract Var acceptMul(IOperationVisitorMul p);
    public abstract Var acceptSub(IOperationVisitorSub p);
    public abstract boolean acceptAssign(IOperationVisitorAssign p);
    public abstract Var getVar();

    @Override
    public Var add(Var var) {
        try{
            throw new CalcErrorException("Сложение невозможно");
        }
        catch (CalcErrorException e){

        }
        return null;
    }

    @Override
    public Var sub(Var var) {
        try{
            throw new CalcErrorException("Вычитание невозможно");
        }
        catch (CalcErrorException e){

        }
        return null;
    }

    @Override
    public Var mul(Var var) {
        try{
            throw new CalcErrorException("Умножение невозможно");
        }
        catch (CalcErrorException e){

        }
        return null;
    }

    @Override
    public Var div(Var var) {
        try{
            throw new CalcErrorException("Деление невозможно");
        }
        catch (CalcErrorException e){

        }
        return null;
    }

    @Override
    public boolean assign(Var var){
        try{
            throw new CalcErrorException("Присвоить значение невозможно");
        }
        catch (CalcErrorException e){

        }
        return false;
    }
    @Override
    public boolean assign(String str){
        try{
            throw new CalcErrorException("Присвоить значение невозможно");
        }
        catch (CalcErrorException e){

        }
        return false;
    }
}
