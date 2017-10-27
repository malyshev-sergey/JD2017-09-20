package by.it.meshchenko.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    // Проверка на корректность операции присваивания (О.П.) ( A=2, A={1,2}, A={{1,2},{3,4}} )
    private static boolean isAssignVarValue(String str){
        boolean res = false;
        try {
            Pattern p = Pattern.compile(Patterns.exAssignNameVarValue);
            Matcher m = p.matcher(str);
            res = m.matches();
        }
        catch (Exception e){
        }
        return res;
    }

    // Проверка на корректность арифметического выражения (А.В.) ( {1,2}+{{1,2},{3,4}} )
    private static boolean isExFullCorrect(String str){
        boolean res = false;
        try {
            Pattern p = Pattern.compile(Patterns.exFull);
            Matcher m = p.matcher(str);
            res = m.matches();
        }
        catch (Exception e){

        }
        return res;
    }

    public static Expression parseAssign(String str){
        Expression res = null;
        try{
            if(isAssignVarValue(str)){
                String[] strMass = str.split(Patterns.exAssign);
                res =  new Expression();
                res.tempEx.put(strMass[0], defineTypeVar(strMass[1]));
            }
        }
        catch (Exception e){}
        return res;
    }

    static Expression parseEx(String str){
        Expression res = null;
        if(isExFullCorrect(str)) {
            res = new Expression();
            StringBuilder strBuildVar = new StringBuilder(str);
            String strVar;
            Pattern p = Pattern.compile(Patterns.exAny);
            Pattern pOper = Pattern.compile(Patterns.exOper);

            Matcher m = p.matcher(strBuildVar);
            if(m.find()) {
                strVar = m.group();
                res.tempEx.put("var1", defineTypeVar(strVar));
                strBuildVar.delete(0, strVar.length());
            }

            Matcher mOper = pOper.matcher(strBuildVar);
            if(mOper.find()) {
                strVar = mOper.group();
                res.tempOp.add(strVar);
                strBuildVar.delete(0, strVar.length());
            }
            m = p.matcher(strBuildVar);
            if(m.find()) {
                strVar = m.group();
                res.tempEx.put("var2", defineTypeVar(strVar));
                strBuildVar.delete(0, strVar.length());
            }
        }
        return res;
    }

    // Соответствие строки паттерну переменной Var
    private static boolean isExVar(String str, String pattern){
        boolean res = false;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        if(m.matches()){
            res = true;
        }
        return res;
    }
    // Если строка соответствует паттерну, return Var
    private static Var defineTypeVar(String str){
        Var res = null;
        if(isExVar(str, Patterns.exVal)){
            res = new VarF(str);
        }
        else if(isExVar(str, Patterns.exVec)){
            res = new VarV(str);
        }
        else if(isExVar(str, Patterns.exMat)){
            res = new VarM(str);
        }
        return res;
    }


}
