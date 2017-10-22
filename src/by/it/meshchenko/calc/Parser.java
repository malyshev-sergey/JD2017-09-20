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
            res.tempEx.put(strMass[0], defineTypeVar(strMass[1]));
        }
        return res;
    }

    public static Expression parseEx(String str){
        Expression res = null;
        if(isExFullCorrect(str)){
            res =  new Expression();
            // Строка с заменёнными значениями переменных (х0 + х1 - х2 / х3)
            String strBuild = new String(str);
            ArrayList<String> strEx = new ArrayList<>();
            Pattern pVarF = Pattern.compile(Patterns.exVal);
            Pattern pVarV = Pattern.compile(Patterns.exVec);
            Pattern pVarM = Pattern.compile(Patterns.exMat);

            Matcher mVarM = pVarM.matcher(strBuild);
            String ex;
            while (mVarM.find()) {
                ex = mVarM.group();
                strBuild = strBuild.replace(ex,"x");// + Integer.toString(op));
                strEx.add(ex);
            }
            Matcher mVarV = pVarV.matcher(strBuild);
            while (mVarV.find()) {
                ex = mVarV.group();
                strBuild = strBuild.replace(ex,"x");// + Integer.toString(op));
                strEx.add(ex);
            }
            Matcher mVarF = pVarF.matcher(strBuild);
            while (mVarF.find()) {
                ex = mVarF.group();
                strBuild = strBuild.replace(ex,"x");// + Integer.toString(op));
                strEx.add(ex);
            }

            Iterator<String> it = strEx.iterator();
            int i = 1;
            while (it.hasNext()){
                res.tempEx.put("var" + i, defineTypeVar(it.next()));
                i++;
            }
            // Собираем в массив операторы выражения
            Pattern p = Pattern.compile(Patterns.exOper);
            Matcher m = p.matcher(strBuild);
            while (m.find()) {
                res.tempOp.add(m.group());
            }
        }
        return res;
    }

    private static Var defineTypeVar(String str){
        Var res = null;
        Pattern pVarF = Pattern.compile(Patterns.exVal);
        Pattern pVarV = Pattern.compile(Patterns.exVec);
        Pattern pVarM = Pattern.compile(Patterns.exMat);
        Matcher mVarF = pVarF.matcher(str);
        Matcher mVarV = pVarV.matcher(str);
        Matcher mVarM = pVarM.matcher(str);
        if(mVarF.matches()){
            return res = new VarF(str);
        }
        else if(mVarV.matches()){
            return res = new VarV(str);
        }
        else if(mVarM.matches()){
            return res = new VarM(str);
        }
        return res;
    }


}
