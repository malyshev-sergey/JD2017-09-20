package by.it.shelkovich.calc.Vars;

import by.it.shelkovich.calc.interfaces.Patterns;

import java.util.regex.Pattern;

public class VarFactory {
    private VarFactory(){}
    private static VarFactory instance;

    public static VarFactory getInstance(){
        if (instance == null)  instance = new VarFactory();
        return instance;
    }

    public Var getVar(String value){
        if (value.charAt(0) != '{') {
            Pattern p = Pattern.compile(Patterns.exVal);
            if (p.matcher(value).matches()) return new VarD(value);

            p = Pattern.compile(Patterns.exName);
            if (p.matcher(value).matches()) return new VarS(value);
            else return null;
        } else if (value.charAt(1) != '{') return new VarV(value);
        else return new VarM(value);
    }

}
