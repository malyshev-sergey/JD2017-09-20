package by.it.meshchenko.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    // Проверка на корректность операции присваивания (О.П.) ( A=2, A={1,2}, A={{1,2},{3,4}} )
    private static boolean isAssignVarValue(String str){
        boolean res = true;
        try {
            Pattern p = Pattern.compile(Patterns.exAssignVarValue);
            Matcher m = p.matcher(str);
            res = m.matches();
        }
        catch (Exception e){
            res = false;
        }
        return res;
    }

    // Проверка на корректность арифметического выражения (А.В.) ( {1,2}+{{1,2},{3,4}} )
    private static boolean isExFullCorrect(String str){
        boolean res = true;
        try {
            Pattern p = Pattern.compile(Patterns.exFull);
            Matcher m = p.matcher(str);
            res = m.matches();
        }
        catch (Exception e){
            res = false;
        }
        return res;
    }

    public static Expression parseAssign(String str){
        Expression res = null;
        if(isAssignVarValue(str)){
            String[] strMass = str.split(Patterns.exAssign);
            res =  new Expression();
            res.tempEx.put(strMass[0], Calc.DefineTypeVariable(strMass[1]));
        }
        return res;
    }

    public static Expression parseEx(String str){
        Expression res = null;
        if(isExFullCorrect(str)){
            res =  new Expression();
            String[] strMass = str.split(Patterns.exAssign);
            for(int i = 0; i < strMass.length; i++){
                res.tempEx.put("var" + i, Calc.DefineTypeVariable(strMass[i]));
            }
            // Собираем в массив операторы выражения
            Pattern p = Pattern.compile(Patterns.exOper);
            Matcher m = p.matcher(str);
            while (m.find()) {
                res.tempOp.add(m.group());
            }
        }
        return res;
    }


}
