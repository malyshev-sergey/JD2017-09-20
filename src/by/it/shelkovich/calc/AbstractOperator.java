package by.it.shelkovich.calc;

public abstract class AbstractOperator implements IOperator {

    protected boolean used = false;
    public boolean getUsed(){
        return used;
    }

    @Override
    public Var add(Var v1, Var v2){
        System.out.println("Операция сложения не поддерживается");
        return null;
    }

    @Override
    public Var sub(Var v1, Var v2){
        System.out.println("Операция вычитания не поддерживается");
        return null;
    }

    @Override
    public Var mul(Var v1, Var v2){
        System.out.println("Операция умножения не поддерживается");
        return null;
    }

    @Override
    public Var div(Var v1, Var v2){
        System.out.println("Операция деления не поддерживается");
        return null;
    }

}
