package by.it.shelkovich.calc;

public abstract class Var implements IOperation{
    private char type;

    char getType (){
        return type;
    }

    Var (char type){
        this.type = type;
    }

    @Override
    public Var add(Var arg){
        System.out.println("Операция сложения не поддерживается");
        return null;
    }

    @Override
    public Var sub(Var arg){
        System.out.println("Операция вычитания не поддерживается");
        return null;
    }

    @Override
    public Var mul(Var arg){
        System.out.println("Операция умножения не поддерживается");
        return null;
    }

    @Override
    public Var div(Var arg){
        System.out.println("Операция деления не поддерживается");
        return null;
    }


    
}
