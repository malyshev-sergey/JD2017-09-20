package by.it.meshchenko.calc;

public class CreatorVar {
    Var getTypeVar(TypeVar t){
        if(t == TypeVar.FLOAT) return new VarF();
        else if(t == TypeVar.VECTOR) return new VarV();
        else if(t == TypeVar.MATRIX) return new VarM();
        else return null;
    }

    boolean typeVarF(Var var){
        if(var != null) {
            String s1 = var.getClass().getSimpleName();
            String s2 = getTypeVar(TypeVar.FLOAT).getClass().getSimpleName();
            return s1.compareTo(s2) == 0;
        }
        return false;
    }
    boolean typeVarV(Var var){
        if(var != null) {
            String s1 = var.getClass().getSimpleName();
            String s2 = getTypeVar(TypeVar.VECTOR).getClass().getSimpleName();
            return s1.compareTo(s2) == 0;
        }
        return false;
    }
    boolean typeVarM(Var var){
        if(var != null) {
            String s1 = var.getClass().getSimpleName();
            String s2 = getTypeVar(TypeVar.MATRIX).getClass().getSimpleName();
            return s1.compareTo(s2) == 0;
        }
        return false;
    }
}
